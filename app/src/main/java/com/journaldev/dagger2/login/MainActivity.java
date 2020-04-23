package com.journaldev.dagger2.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.journaldev.dagger2.databinding.ActivityMainBinding;
import com.journaldev.dagger2.R;

import javax.inject.Inject;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        // Binding two-sides
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    //    LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
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
