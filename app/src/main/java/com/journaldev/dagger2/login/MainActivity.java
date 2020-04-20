package com.journaldev.dagger2.login;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.journaldev.dagger2.Module.ViewModelFactory;
import com.journaldev.dagger2.SecondActivity;
import com.journaldev.dagger2.databinding.ActivityMainBinding;
import com.journaldev.dagger2.network.Api;
import com.journaldev.dagger2.Component.MyComponent;
import com.journaldev.dagger2.network.Controller;
import com.journaldev.dagger2.R;
import com.journaldev.dagger2.model.Login;
import javax.inject.Inject;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        // Binding two-sides
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        activityMainBinding.setLoginviewmodel(loginViewModel);

        //Check type of Internet connection
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        boolean isMetered = cm.isActiveNetworkMetered();
        System.out.println("YOU ARE CONNECTED TO INTERNET: " + isConnected);
        System.out.println("TYPE OF CONNECTION TO INTERNET: " + isMetered);
    }

}
