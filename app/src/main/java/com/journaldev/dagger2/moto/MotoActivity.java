package com.journaldev.dagger2.moto;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.journaldev.dagger2.R;
import com.journaldev.dagger2.databinding.ActivityMainBinding;
import com.journaldev.dagger2.databinding.ActivitySecondBinding;

import javax.inject.Inject;

public class MotoActivity extends AppCompatActivity {

    @Inject
    MotoViewModel motoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        activitySecondBinding.setMotoViewModel(motoViewModel);
    }
}

// подключить интерсептор в ретрофит.