package com.ar.daggerapp;

import android.util.Log;

//We dont own this class , consider it as a third party lib
//where we cant control its constructor or add @Inject to it.
//So we use provides in dagger for this purpose.
class Tires {

    private static final String TAG = "Tires";

    public Tires() {
    }

    public void inflate() {
        Log.d(TAG, "inflate: ");
    }
}
