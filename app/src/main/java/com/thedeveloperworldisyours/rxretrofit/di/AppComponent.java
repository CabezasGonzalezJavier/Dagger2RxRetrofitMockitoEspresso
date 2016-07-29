package com.thedeveloperworldisyours.rxretrofit.di;

import android.content.Context;

import com.thedeveloperworldisyours.rxretrofit.MainActivity;
import com.thedeveloperworldisyours.rxretrofit.rest.ApiClient;

import dagger.Component;

/**
 * Created by javierg on 28/07/16.
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);

    @AppScope
    Context appContext();

    ApiClient apiService();
}
