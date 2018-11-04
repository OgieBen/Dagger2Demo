package com.ravenshell.dagger2demo;

import android.app.Application;

import com.ravenshell.dagger2demo.di.component.DaggerWeatherComponent;
import com.ravenshell.dagger2demo.di.component.WeatherComponent;
import com.ravenshell.dagger2demo.di.module.AppModule;
import com.ravenshell.dagger2demo.di.module.WeatherModule;

public class App extends Application {

    private WeatherComponent mWeatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mWeatherComponent = DaggerWeatherComponent
                .builder()
                .appModule(new AppModule(this))
                .weatherModule(new WeatherModule())
                .build();
    }

    public WeatherComponent getWeatherComponent(){
        return mWeatherComponent;
    }


}
