package com.journaldev.dagger2.Module;

import com.journaldev.dagger2.SecondActivity;
import com.journaldev.dagger2.login.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    //аннотация служит для генерации AndroidInjector для возвращаемого типа метода, над которым указана аннотация
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    abstract SecondActivity contributesSecondActivity();
}
