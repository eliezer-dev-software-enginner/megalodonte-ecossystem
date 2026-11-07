package megalodonte_app5_todo_list;

import megalodonte.ListenerManager;
import megalodonte.application.MegalodonteApp;
import megalodonte.application.MegalodonteApplication;
import megalodonte.base.theme.ThemeManager;
import megalodonte.theme.DefaultTheme;

public class Main {

    public static final class AppHost extends MegalodonteApplication {}

    static void main(String[] args) {
        ThemeManager.setTheme(new DefaultTheme());
        MegalodonteApp.appName("Megalodonte Todo List");
        MegalodonteApp.appIcon("/icon.png");

        MegalodonteApp.run(AppHost.class, args, context -> context.useView(new HomeScreen()), ev->{
            if(ev == MegalodonteApp.Event.CloseRequest){
                System.out.println("Clicked on X - close application");
                ListenerManager.disposeAll();
            }
        });
    }
}
