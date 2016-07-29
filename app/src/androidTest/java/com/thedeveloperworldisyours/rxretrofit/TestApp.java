package com.thedeveloperworldisyours.rxretrofit;

import com.thedeveloperworldisyours.rxretrofit.di.DaggerTestAppComponent;
import com.thedeveloperworldisyours.rxretrofit.di.TestAppComponent;
import com.thedeveloperworldisyours.rxretrofit.di.TestAppModule;

/**
 * Created by javierg on 28/07/16.
 */
public class TestApp extends App {

    private TestAppComponent testAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        testAppComponent = DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .build();
    }

    @Override
    public TestAppComponent appComponent() {
        return testAppComponent;
    }
}