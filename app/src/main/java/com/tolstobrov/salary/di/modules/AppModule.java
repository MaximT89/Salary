package com.tolstobrov.salary.di.modules;

import android.content.Context;

import com.tolstobrov.salary.services.NetworkService;
import com.tolstobrov.salary.services.impl.NetworkServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }
}
