package com.thedeveloperworldisyours.rxretrofit;

import android.app.Application;

import com.thedeveloperworldisyours.rxretrofit.di.AppComponent;
import com.thedeveloperworldisyours.rxretrofit.di.AppModule;
import com.thedeveloperworldisyours.rxretrofit.di.DaggerAppComponent;

/**
 * Created by javierg on 28/07/16.
 */
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}
