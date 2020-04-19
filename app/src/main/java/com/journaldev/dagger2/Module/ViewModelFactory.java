package com.journaldev.dagger2.Module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.journaldev.dagger2.login.LoginRepository;
import com.journaldev.dagger2.login.LoginViewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {


    LoginRepository loginRepository;

    @Inject
    public ViewModelFactory(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(loginRepository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
