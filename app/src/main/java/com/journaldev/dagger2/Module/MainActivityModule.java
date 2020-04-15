package com.journaldev.dagger2.Module;

import com.journaldev.dagger2.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    //аннотация служит для генерации AndroidInjector для возвращаемого типа метода, над которым указана аннотация
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

}
