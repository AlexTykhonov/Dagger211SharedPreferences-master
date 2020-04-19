package com.journaldev.dagger2.login;

import android.content.SharedPreferences;
import com.journaldev.dagger2.model.Login;
import com.journaldev.dagger2.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {

    Api api;

    SharedPreferences sharedPreferences;

    public LoginRepository(Api api, SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.api = api;
    }

    void apiLogin (Login login) {
        api.login(login)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", s.getToken());
                    editor.apply();
                    System.out.println("=====>>>> "+sharedPreferences.getString("token", "default"));
                }, e -> System.out.println("     ERROR!!!     " + e ));
    }
}

// Login("Andrew", "password")