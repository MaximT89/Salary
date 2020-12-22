package com.tolstobrov.salary.di;

import android.app.Application;

import com.tolstobrov.salary.di.components.AppComponent;
import com.tolstobrov.salary.di.components.DaggerAppComponent;
import com.tolstobrov.salary.di.modules.AppModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
