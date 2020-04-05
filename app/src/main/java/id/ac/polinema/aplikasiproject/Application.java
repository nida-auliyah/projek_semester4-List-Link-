package id.ac.polinema.aplikasiproject;

import id.ac.polinema.aplikasiproject.models.Activity;
import id.ac.polinema.aplikasiproject.models.Main;

public class Application extends android.app.Application{
    private static Activity app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = new Activity();
    }
    public static Activity getAccount() {
        return app;
    }
}
