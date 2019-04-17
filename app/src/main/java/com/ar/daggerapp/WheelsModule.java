package com.ar.daggerapp;

import dagger.Module;
import dagger.Provides;

//Note - If all methods in module are static , then mark module class as abstract,
//so that it doesnt create its implementation which is deprecated.
@Module
public abstract class WheelsModule {

    //when here any of the provides method doesn't depend on
    //the instance state of the module, we can declare them static so that
    //dagger doesn't have to instantiate its module and call this methods directly on the class

    @Provides
    static Rims providesRims() {
        //using new since we cant inject its constructor
        //so we create its object here.
        return new Rims();

    }

    @Provides
    static Tires providesTires() {
        Tires tires = new Tires();
        //in module we can do other configurations with objects
        //such as call its methods to do something and then return that object
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
