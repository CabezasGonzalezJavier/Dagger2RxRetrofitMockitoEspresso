package com.thedeveloperworldisyours.rxretrofit.rest;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.google.gson.Gson;
import com.thedeveloperworldisyours.rxretrofit.data.Data;
import com.thedeveloperworldisyours.rxretrofit.model.GeoNames;

import java.util.concurrent.TimeUnit;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by javierg on 28/07/16.
 */
public class MockApiClient implements ApiClient {

    @Override
    public Observable<GeoNames> getAllCountriesGeoNames(@Query("lang") String lang, @Query("username") String username) {
        GeoNames geoNames = new Gson().fromJson(Data.DATA_JSON, GeoNames.class);

        return Observable.just(geoNames).delay(1, TimeUnit.SECONDS);
    }
}
