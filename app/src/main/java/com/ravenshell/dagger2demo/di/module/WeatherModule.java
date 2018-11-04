package com.ravenshell.dagger2demo.di.module;

import com.ravenshell.dagger2demo.network.OpenWeatherInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    @Provides
    OpenWeatherInterface providesOpenWeatherInterface(Retrofit retrofit){
        return retrofit.create(OpenWeatherInterface.class);
    }
}
