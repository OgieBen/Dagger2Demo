package com.ravenshell.dagger2demo.network;

import com.ravenshell.dagger2demo.data.weather.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenWeatherInterface {

    // one day preview
    @GET("weather?lat={lat}&lon={lon}")
    Call<WeatherData> getWeatherData(@Path("lat") double latitude, @Path("lon") double longitude);


   /* @GET("daily?lat={lat}&lon={lon}&cnt=16")
    Call<List<Weather>> getWeatherData(@Path("lat") double latitude, @Path("lon") double longitude);*/


}
