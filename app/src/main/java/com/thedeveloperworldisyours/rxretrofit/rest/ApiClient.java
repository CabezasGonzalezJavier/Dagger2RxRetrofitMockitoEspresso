package com.thedeveloperworldisyours.rxretrofit.rest;

import com.thedeveloperworldisyours.rxretrofit.model.GeoNames;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by javierg on 28/07/16.
 */
public interface ApiClient {
    @GET("/countryInfoJSON")
    Observable<GeoNames> getAllCountriesGeoNames(@Query("lang") String lang, @Query("username") String username);


}
