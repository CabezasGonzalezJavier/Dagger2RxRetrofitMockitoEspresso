package com.thedeveloperworldisyours.rxretrofit.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by javierg on 28/07/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
