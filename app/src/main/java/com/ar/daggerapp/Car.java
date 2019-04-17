package com.ar.daggerapp;

import android.util.Log;

import javax.inject.Inject;
// uses java inject since if dagger is replaced with some
//other DI framework, we don't need to modify this class

public class Car {

    //The order of injection is constructor -> field -> method



    private static final String TAG = "Car";

    //Here we are injecting stereo as a field and not in constructor but this is
    //automatically injected whereas in activity we have to call inject(Activity)
    //method and not here. bcoz here we are doing constructor injection which are only
    //automatically executed when we call constructor injection. But in activity,
    //we dont call activity const. , so we manually call inject() method from component.
    //In activity, when we call inject(), it will do field injection as well method injection.
    @Inject
    public Stereo stereo;
    //Its an interface here
    Engine engine;
    private Wheels wheels;

    // here dagger know that this is the way to construct car component
    // can be used only on single constructor.
    //Here we use constructor injection since we are only initializing it through const
    //while in activity we have to ger it from Component since we have no control over
    //activity object creation/ initialization / constructor since Android does it for us.
    //Constructor injection.


    //We could also have created car module like wheels module but since we have inject
    //annotation here / we can control it , dagger knows from here to create car object.
    //But it will take wheels module to construct wheels since we made it an ext. lib
    @Inject
    public Car(
//        Stereo stereo,
        Wheels wheels,
        //Here dagger doesnt know whether to provide diesel or petrol engine since
        //its an interface
        Engine engine) {
//        this.stereo = stereo;
        this.wheels = wheels;
        this.engine = engine;
    }

    //method injection
    //this method will be called by dagger automatically
    //after the construction injection, we don't need to call
    @Inject
    public void enableRemote(Remote remote){
        remote.setListener(this);
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "driving..");
    }
}
