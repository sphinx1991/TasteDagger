package com.ar.daggerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //field injection, no private fields,
    //for this to work , we add inject method in component and pass this activity.
    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //in activity we have to ger it from Component since we have no control over
        //activity initialization / constructor since Android does it for us.

        //Now we can get this create method only when the none of the component
        //module takes an argument in its constructor.
//        CarComponent carComponent = DaggerCarComponent.create();

        //If it takes any arg in its const. , then we use builder to pass that value.
        //we are passing horsepower/appcontext at runtime.

        CarComponent carComponent = DaggerCarComponent.builder()
            //commented to check Builder interface created for petrol engine module
//            .dieselEngineModule(new DieselEngineModule(100))
            .horsePower(100)
            .engineCap(1500)


            //this below is deprecated since its not taking any instance or argument
            //and its abstract and dagger doest create its impl so, it marks it
            //as deprecated. So now we will make WheelsModule as abstract so its doesnt
            //create this deprecated class.
            //Note - If all methods in module are static , then mark module class as abstract.
//            .wheelsModule()
            .build();
//        car = carComponent.getCar();

        //for field injection.
        carComponent.inject(this);

        car.drive();
    }
}
