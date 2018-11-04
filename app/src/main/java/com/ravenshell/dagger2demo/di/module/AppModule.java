package com.ravenshell.dagger2demo.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Application provideApplication(Application app){
        return app;
    }
}
