package com.journaldev.dagger2.moto;


import android.arch.lifecycle.ViewModel;

import com.journaldev.dagger2.login.LoginRepository;

import javax.inject.Inject;

public class MotoViewModel extends ViewModel {

    LoginRepository loginRepository;

    @Inject
    public MotoViewModel(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
    }

}
