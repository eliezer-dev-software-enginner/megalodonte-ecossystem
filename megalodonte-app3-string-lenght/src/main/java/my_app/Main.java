package my_app;

import megalodonte.ListenerManager;
import megalodonte.application.MegalodonteApp;
import megalodonte.base.theme.ThemeManager;
import megalodonte.theme.DefaultTheme;

public class Main {

    static void main() {
        ThemeManager.setTheme(new DefaultTheme());

        MegalodonteApp.run(context -> context.useView(new HomeScreen()), ev->{
            if(ev == MegalodonteApp.Event.CloseRequest){
                System.out.println("Clicked on X - close application");
                ListenerManager.disposeAll();
            }
        });
    }
}
