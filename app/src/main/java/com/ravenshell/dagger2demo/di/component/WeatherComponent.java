package com.ravenshell.dagger2demo.di.component;

import com.ravenshell.dagger2demo.MainActivity;
import com.ravenshell.dagger2demo.di.module.AppModule;
import com.ravenshell.dagger2demo.di.module.WeatherModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={WeatherModule.class, AppModule.class})
public interface WeatherComponent {
    void inject(MainActivity activity);
}
