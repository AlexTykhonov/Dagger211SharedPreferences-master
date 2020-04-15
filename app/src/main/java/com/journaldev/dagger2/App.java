package com.journaldev.dagger2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.journaldev.dagger2.Component.DaggerMyComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    Context context;

    @Inject
DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
//содержит коллекцию фабрик для создания сабкомпонента (AndroidInjector) для определенного типа

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        context=getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private void initDagger(){
        DaggerMyComponent.builder().application(this).build().inject(this);
    }
}
