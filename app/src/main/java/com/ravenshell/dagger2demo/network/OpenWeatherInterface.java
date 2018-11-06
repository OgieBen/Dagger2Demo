package com.ravenshell.dagger2demo.network;

import com.ravenshell.dagger2demo.data.weather.WeatherData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherInterface {

    // one day preview
    @GET("weather")
    Observable<WeatherData> getWeatherData(@Query("lat") double lat, @Query("lon") double lon);


   /* @GET("daily?lat={lat}&lon={lon}&cnt=16")
    Call<List<Weather>> getWeatherData(@Path("lat") double latitude, @Path("lon") double longitude);*/


}
