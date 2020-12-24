package com.tolstobrov.salary;

import android.app.Application;

import com.tolstobrov.salary.di.components.AppComponent;
import com.tolstobrov.salary.di.components.DaggerAppComponent;
import com.tolstobrov.salary.di.modules.AppModule;

public class App extends Application {

    private static App app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static App app(){
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
