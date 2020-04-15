package com.journaldev.dagger2;


import android.content.SharedPreferences;

import com.journaldev.Api;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    Interceptor headerInterceptor;

    public Controller(Interceptor headerInterceptor) {
        this.headerInterceptor = headerInterceptor;
    }

    public Controller() { }

    final String BASE_URL = "https://fluxjwt.herokuapp.com/";
    private  OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();

    private  retrofit2.Retrofit.Builder sBuilder =
            new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public Api createService() {
//        sHttpClient.addInterceptor(headerInterceptor);
        retrofit2.Retrofit retrofit = sBuilder
//                .client(sHttpClient.build())
                .build();
        return  retrofit.create(Api.class);
    }

}

