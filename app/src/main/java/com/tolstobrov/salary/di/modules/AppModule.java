package com.tolstobrov.salary.di.modules;

import android.content.Context;

import androidx.room.Room;

import com.tolstobrov.salary.database.AppDatabase;
import com.tolstobrov.salary.database.SalaryDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "salary").build();
    }

    @Provides
    @Singleton
    public SalaryDao provideSalaryDao(AppDatabase appDatabase){
        return appDatabase.getSalaryDao();
    }
}
