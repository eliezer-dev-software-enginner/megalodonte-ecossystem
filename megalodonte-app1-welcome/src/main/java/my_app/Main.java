package my_app;

import java.util.Set;

import megalodonte.ListenerManager;

import megalodonte.application.Context;
import megalodonte.application.MegalodonteApp;
import my_app.hotreload.HotReload;

public class Main {
    static HotReload hotReload;
    static boolean devMode = "true".equals(System.getenv("DEV_MODE"));

    static void main() {
        MegalodonteApp.run(context -> {

            initialize(context);

            if (devMode) {
                hotReload = new HotReload()
                        .sourcePath("src/main/java")
                        .classesPath("build/classes/java/main")
                        .resourcesPath("src/main/resources")
                        .implementationClassName("my_app.hotreload.Reloader")
                        .screenClassName(null)
                        .reloadContext(context)
                        .classesToExclude(Set.of("my_app.Main"));
                hotReload.start();
            }

        }, ev->{
            if(ev == MegalodonteApp.Event.CloseRequest){
                System.out.println("Clicked on X - close application");
                ListenerManager.disposeAll();
            }
        });
    }

    // mandatory for hotreload
    public static void initialize(Context context) {
        context.useView(WelcomeScreen.class);
    }
}
