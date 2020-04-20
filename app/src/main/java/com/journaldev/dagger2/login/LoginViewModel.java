package com.journaldev.dagger2.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;

import com.journaldev.dagger2.model.Login;

public class LoginViewModel extends ViewModel  {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Login> loginMutableLiveData;
    public MutableLiveData<Boolean> check = new MutableLiveData<>();

    public MutableLiveData<Login> getLoginMutableLiveData() {
        if (loginMutableLiveData == null) {
            loginMutableLiveData = new MutableLiveData<>();
        }
        return loginMutableLiveData;
    }

    LoginRepository loginRepository;

    public LoginViewModel (LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login (View view) {
        Login login = new Login(email.getValue(), password.getValue());
        loginRepository.apiLogin(login, view);
    }
}
