package com.ravenshell.dagger2demo.network;

import com.ravenshell.dagger2demo.data.weather.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenWeatherInterface {

    @GET("weather?lat={lat}&lon={lon}")
    Call<List<Weather>> getWeatherData(@Path("lat") double latitude, @Path("lon") double longitude);
}
