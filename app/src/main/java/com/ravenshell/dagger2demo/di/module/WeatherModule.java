package com.ravenshell.dagger2demo.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ravenshell.dagger2demo.Utils.Const;
import com.ravenshell.dagger2demo.network.OpenWeatherInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WeatherModule {

    @Provides
    @Singleton
    Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    OpenWeatherInterface providesOpenWeatherInterface(Retrofit retrofit){
        return retrofit.create(OpenWeatherInterface.class);
    }
}
