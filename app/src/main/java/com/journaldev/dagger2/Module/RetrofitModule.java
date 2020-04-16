package com.journaldev.dagger2.Module;

import com.journaldev.dagger2.network.Api;
import com.journaldev.dagger2.network.Controller;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {
    @Singleton
    @Provides
    public Controller createController () {
        return new Controller();
    }

    @Singleton
    @Provides
    public Api createApi (Controller controller) {
       return controller.createService();
    }
}
