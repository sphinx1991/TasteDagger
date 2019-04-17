package com.ar.daggerapp;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {

    private static final String TAG = "PetrolEngine";
    private int horsepower;
    private int engineCap;

    @Inject
    public PetrolEngine(@Named("horse power") int horsepower,
                        @Named("engine cap")int engineCap) {
        this.horsepower = horsepower;
        this.engineCap = engineCap;
    }

    @Override
    public void start() {
        Log.d(TAG, "start:Petrol Engine ");
    }
}
