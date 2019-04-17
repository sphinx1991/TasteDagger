package com.ar.daggerapp;

//We dont own this class , consider it as a third party lib
//where we cant control its constructor or add @Inject to it.
//So we use provides in dagger for this purpose.
class Rims {

    public Rims() {
    }
}
