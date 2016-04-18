package com.example.mvp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Business logic: We use Retrofit to load a list of EarthQuakes from a web service
interface EarthquakesService {

    // http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-04-01&endtime=2016-04-30
    @GET("fdsnws/event/1/query?format=geojson")
    Call<FeatureCollection> getEarthquakes(@Query("starttime") String startTime, @Query("endtime") String endTime);
}