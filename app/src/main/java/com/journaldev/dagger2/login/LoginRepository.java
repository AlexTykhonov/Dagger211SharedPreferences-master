package com.journaldev.dagger2.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.journaldev.dagger2.SecondActivity;
import com.journaldev.dagger2.model.Login;
import com.journaldev.dagger2.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {

    Api api;
    SharedPreferences sharedPreferences;
    MainActivity mainActivity;
    Boolean check = false;

    public LoginRepository(Api api, SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.api = api;
    }

    void apiLogin (Login login, View view) {
        api.login(login)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", s.getToken());
                    editor.apply();
                    System.out.println("=====>>>> "+sharedPreferences.getString("token", "default"));
                    newActivity(view);
                }, e -> {
                    System.out.println("     ERROR!!!     " + e );
                    Toast.makeText(view.getContext(), "Wrong Credentials!", Toast.LENGTH_LONG).show();
                });
    }

    void newActivity(View view) {
    Intent intent = new Intent(view.getContext(), SecondActivity.class);
    view.getContext().startActivity(intent);
    }

}

// Login("Andrew", "password")