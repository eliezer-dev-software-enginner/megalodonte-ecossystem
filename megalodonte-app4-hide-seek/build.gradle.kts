import java.util.Properties

plugins {
    id("java")
    id("maven-publish")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("com.gradleup.shadow") version "8.3.5"
}

val props = Properties()
file("gradle.properties").inputStream().use { props.load(it) }

group = "megalodonte_app"
version = props.getProperty("appVersion")

repositories {
    mavenCentral()
    mavenLocal()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

javafx {
    version = "25.0.1"

    modules("javafx.controls", "javafx.graphics")
}

dependencies {
    implementation("megalodonte:megalodonte-base:1.0.0-beta")
    implementation("megalodonte:megalodonte-components:1.0.0-beta")
    implementation("megalodonte:megalodonte-reactivity:1.0.0-beta")
    implementation("megalodonte:megalodonte-theme:1.0.0-beta")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set(props.getProperty("appMainClass"))
}

tasks.named<JavaExec>("run") {
    // Reading JAVAFX_MODULES_HOME has to happen in doFirst, not directly in this
    // configuration block: tasks.named { ... } runs at CONFIGURATION time, which
    // Gradle triggers just to build the task graph (e.g. `./gradlew tasks`, or an
    // IDE's Gradle sync) — well before the "run" task actually executes, and
    // possibly in a process that never inherited the shell's environment. That's
    // what caused "undefined variable" errors even when it was set in the shell
    // running `./gradlew run` directly. doFirst only runs when this task executes.
    doFirst {
        val os = System.getProperty("os.name").lowercase()

        val javafxModulesHome = System.getenv("JAVAFX_MODULES_HOME")
            ?: throw GradleException(
                "Environment variable JAVAFX_MODULES_HOME is not set. " +
                        "Point it to the folder containing linux-25.0.1/ and windows-25.0.1/."
            )

        val fxPath = if (os.contains("win")) {
            "$javafxModulesHome/windows-25.0.1/lib"
        } else {
            "$javafxModulesHome/linux-25.0.1/lib"
        }

        jvmArgs = listOf(
            "--module-path", fxPath,
            "--add-modules", "javafx.controls,javafx.graphics",
            "--enable-native-access=ALL-UNNAMED",
            "-Dprism.verbose=true"
        )
    }

    environment("DEV_MODE", "true")
}

tasks.shadowJar {
    dependsOn(tasks.test)
    archiveBaseName.set(props.getProperty("appName"))
    archiveClassifier.set("")
    mergeServiceFiles() // equivalente ao ServicesResourceTransformer

    manifest {
        attributes(
            "Main-Class" to props.getProperty("appMainClass")
        )
    }

    // Exclui JavaFX (como o pom.xml fazia)
    exclude("org/openjfx/**")

    // 🔥 remove assinaturas quebradas (igual no Maven)
    exclude("META-INF/*.SF")
    exclude("META-INF/*.DSA")
    exclude("META-INF/*.RSA")
}

tasks.jar {
    enabled = false
    archiveBaseName.set(props.getProperty("appName"))

    manifest {
        attributes(
            "Implementation-Title" to "JavaFX ${props.getProperty("appName")} app",
            "Implementation-Version" to project.version,
            "Main-Class" to props.getProperty("appMainClass")
        )
    }

    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}


// Configuração de Publicação (mantida)
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = props.getProperty("appName")
        }
    }
}