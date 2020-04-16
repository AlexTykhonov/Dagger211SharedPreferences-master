package com.journaldev.dagger2.network;

import com.journaldev.dagger2.model.Login;
import com.journaldev.dagger2.model.Moto;
import com.journaldev.dagger2.model.Token;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @POST("authorize/login")
    Observable<Token> login (@Body Login login);

    @GET("moto")
    Observable<List<Moto>> getMoto ();

}