package megalodonte_app1_welcome;

import megalodonte.application.MegalodonteApp;
import megalodonte.application.MegalodonteApplication;
import megalodonte.base.theme.ThemeManager;
import megalodonte.theme.DefaultTheme;

public class Main {

    public static final class AppHost extends MegalodonteApplication {}

    static void main(String[] args) {
        ThemeManager.setTheme(new DefaultTheme());
        MegalodonteApp.appName("Megalodonte Welcome");
        MegalodonteApp.appIcon("/icon.png");

        MegalodonteApp.run(AppHost.class, args, context -> context.useView(new HomeScreen()));
    }
}
