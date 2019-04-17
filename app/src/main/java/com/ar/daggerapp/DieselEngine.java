package com.ar.daggerapp;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {

    private static final String TAG = "DieselEngine";
    private int horsePower;

//    @Inject
    //we removed inject since we will get horsepower at runtime
    //and dagger cant provide it here. So we need to create this object manually.
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start:Diesel Engine  ");
    }
}
