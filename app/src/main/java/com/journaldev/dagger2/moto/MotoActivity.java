package com.journaldev.dagger2.moto;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.journaldev.dagger2.R;
import com.journaldev.dagger2.databinding.ActivityMainBinding;
import com.journaldev.dagger2.databinding.ActivitySecondBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MotoActivity extends AppCompatActivity {

    @Inject
    MotoViewModel motoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        activitySecondBinding.setMotoViewModel(motoViewModel);

        System.out.println(" ooooooo MOTOREPOSITORY ->  "+motoViewModel.getListObservable());

        motoViewModel.getListObservable().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(m-> System.out.println(m));
    }

}

