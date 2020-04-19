package com.journaldev.dagger2.Module;

import android.arch.lifecycle.ViewModelProvider;
import android.content.SharedPreferences;

import com.journaldev.dagger2.login.LoginRepository;
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


//    // ADDED
    @Provides
    @Singleton
    LoginRepository getRepository(Api apiCallInterface, SharedPreferences sharedPreferences) {
        return new LoginRepository(apiCallInterface, sharedPreferences);
    }
//
//    @Provides
//    @Singleton
//    ViewModelProvider.Factory getViewModelFactory(LoginRepository myRepository) {
//        return new ViewModelFactory(myRepository);
//    }
}
