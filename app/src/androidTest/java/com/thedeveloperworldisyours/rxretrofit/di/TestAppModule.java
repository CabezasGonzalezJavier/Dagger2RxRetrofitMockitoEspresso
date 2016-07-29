package com.thedeveloperworldisyours.rxretrofit.di;

import android.content.Context;

import com.thedeveloperworldisyours.rxretrofit.rest.ApiClient;
import com.thedeveloperworldisyours.rxretrofit.rest.MockApiClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 28/07/16.
 */
@Module
public class TestAppModule {
    private final Context context;

    public TestAppModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides @AppScope public Context provideAppContext() {
        return context;
    }

    @Provides
    public ApiClient provideWeatherApiClient() {
        return new MockApiClient();
    }
}
