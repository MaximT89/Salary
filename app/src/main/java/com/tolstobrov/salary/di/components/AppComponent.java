package com.tolstobrov.salary.di.components;

import com.tolstobrov.salary.activities.MainActivity;
import com.tolstobrov.salary.di.modules.AppModule;
import com.tolstobrov.salary.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
