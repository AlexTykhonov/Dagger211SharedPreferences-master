package com.journaldev.dagger2.Module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.journaldev.dagger2.Controller;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anupamchugh on 06/11/17.
 */

@Module
public class SharedPrefModule {
    private Context context;

    @Singleton
    @Provides
    public Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public Controller createController () {
        return new Controller();
    }
}
