package com.tolstobrov.salary.di.modules;

import android.content.Context;

import com.tolstobrov.salary.services.NetworkService;
import com.tolstobrov.salary.services.impl.NetworkServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.class)
public class NetworkModule {

    @Provides
    @Singleton
    NetworkService provideNetworkService(Context context){
        return new NetworkServiceImpl(context);
    }
}
