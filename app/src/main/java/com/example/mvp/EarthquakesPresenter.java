package com.example.mvp;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakesPresenter extends MvpBasePresenter<EarthquakesView> {

    public void loadEarthquakes(final boolean pullToRefresh, String startTime, String endTime){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://earthquake.usgs.gov")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EarthquakesService service = retrofit.create(EarthquakesService.class);

        Call<FeatureCollection> earthquakes = service.getEarthquakes(startTime, endTime);

        earthquakes.enqueue(new Callback<FeatureCollection>() {
            @Override
            public void onResponse(Call<FeatureCollection> call, Response<FeatureCollection> response) {
                if (isViewAttached()){
                    getView().setData(response.body().getFeatures());
                    getView().showContent();
                }
            }

            @Override
            public void onFailure(Call<FeatureCollection> call, Throwable t) {
                if(isViewAttached())
                    getView().showError(t.getCause(), pullToRefresh);
            }
        });
    }
}
