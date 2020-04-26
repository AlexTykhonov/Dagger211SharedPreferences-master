package com.journaldev.dagger2.moto;


import android.arch.lifecycle.ViewModel;

import com.journaldev.dagger2.login.LoginRepository;
import com.journaldev.dagger2.model.Moto;
import com.journaldev.dagger2.network.Api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MotoViewModel extends ViewModel {

    Observable<List<Moto>> listObservable;
    MotoRepository motoRepository;

    @Inject
    public MotoViewModel(MotoRepository motoRepository) {
    this.motoRepository = motoRepository;
    }

    public  Observable<List<Moto>> getListObservable () {

        return motoRepository.apiMoto();
    }

}
