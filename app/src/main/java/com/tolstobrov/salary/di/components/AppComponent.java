package com.tolstobrov.salary.di.components;

import com.tolstobrov.salary.ui.activities.MainActivity;
import com.tolstobrov.salary.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
