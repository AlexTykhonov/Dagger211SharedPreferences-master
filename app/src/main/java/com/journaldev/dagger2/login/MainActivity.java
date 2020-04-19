package com.journaldev.dagger2.login;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.journaldev.dagger2.Module.ViewModelFactory;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    private MyComponent myComponent;

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Controller controller;

    @Inject
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        activityMainBinding.setLoginviewmodel(loginViewModel);

        initViews();
       // Api api = controller.createService();

//        api.login(new Login("Andrew", "password"))
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> {
//                    System.out.println("TOKEN -----> "+s);
//                }, e -> System.out.println("     ERROR!!!     " + e+ " &&& "+sharedPreferences.getString("token", "no token")));

        //CHECK INTERNET CONNECTION
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        boolean isMetered = cm.isActiveNetworkMetered();


        System.out.println("YOU ARE CONNECTED TO INTERNET: "+isConnected);
        System.out.println("TYPE OF CONNECTION TO INTERNET: "+isMetered);
    }

    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGet:
                inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));
                break;
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
                break;

        }
    }

}

//реализовать ввод пассворд и пароль через форму, получить токен и вывести в консоль