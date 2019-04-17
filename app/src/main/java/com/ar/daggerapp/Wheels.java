package com.ar.daggerapp;


//We don't own this class , consider it as a third party lib
//where we cant control its constructor or add @Inject to it.
//So we use provides in modules in dagger for this purpose.
public class Wheels {

    private Rims rims;
    private Tires tires;

    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
