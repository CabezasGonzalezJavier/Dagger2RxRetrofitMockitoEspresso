package com.thedeveloperworldisyours.rxretrofit.runner;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.thedeveloperworldisyours.rxretrofit.TestApp;

/**
 * Created by javierg on 28/07/16.
 */
public class TestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        String testApplicationClassName = TestApp.class.getCanonicalName();
        return super.newApplication(cl, testApplicationClassName, context);
    }

}
