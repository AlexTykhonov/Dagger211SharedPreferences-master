package com.journaldev.dagger2.Component;

import android.app.Application;

import com.journaldev.dagger2.App;
import com.journaldev.dagger2.MainActivity;
import com.journaldev.dagger2.Module.MainActivityModule;
import com.journaldev.dagger2.Module.SharedPrefModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by anupamchugh on 06/11/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, SharedPrefModule.class, MainActivityModule.class})
//AndroidSupportInjectionModule содержит в себе мультибайндиг коллекций с фабриками для создания сабкомпонентов, которые были сгенерированы с помощью аннотации @ContributesAndroidInjector
public interface MyComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        MyComponent build();
    }
    void inject(App app);
}
