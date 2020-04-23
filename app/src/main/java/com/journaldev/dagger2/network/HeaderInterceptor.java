package com.journaldev.dagger2.network;

import android.content.SharedPreferences;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    String tokenString;
    SharedPreferences sharedPreferences;

    @Inject
    public HeaderInterceptor(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
      //  PreferencesManager pm = DataManager.getInstance().getPreferencesManager();
        SharedPreferences.Editor editor= sharedPreferences.edit();

        Request original = chain.request();
        System.out.println(original.url());
        System.out.println("******* "+(original.url().toString()=="https://fluxjwt.herokuapp.com/authorize/login"));
        Request.Builder requestBuilder;
        if(original.url().toString().equals("https://fluxjwt.herokuapp.com/authorize/login")){
            requestBuilder = original.newBuilder();
            System.out.println(">>>>>>>>ORIGINAL URL FROM Header Int "+original.url()+" "+original.headers());
        }else {
            requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer "+sharedPreferences.getString("token", "empty"));
            System.out.println(">>>>>>>>TOKEN FROM Header Int "+sharedPreferences.getString("token", "empty"));
        }
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}