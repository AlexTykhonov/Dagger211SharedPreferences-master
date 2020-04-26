package com.journaldev.dagger2.moto;

import com.journaldev.dagger2.model.Moto;
import com.journaldev.dagger2.network.Api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MotoRepository {

    Api api;

    public MotoRepository(Api api) {
    this.api = api;
    }

    Observable<List<Moto>> apiMoto () {
       return api.getMoto();

    }
}
