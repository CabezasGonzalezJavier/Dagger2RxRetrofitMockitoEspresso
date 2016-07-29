package com.thedeveloperworldisyours.rxretrofit.di;

import com.thedeveloperworldisyours.rxretrofit.MainActivityTest;

import dagger.Component;

/**
 * Created by javierg on 28/07/16.
 */
@AppScope
@Component(modules = TestAppModule.class)
public interface TestAppComponent extends AppComponent {

    void inject(MainActivityTest test);

}
