package com.ar.daggerapp;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

//this is where activities get their dependencies to use
//dagger 1 uses reflection which is done at runtime but dagger 2 uses annotation processing
//which is done at compile time.
@Component (modules = {WheelsModule.class, PetrolEngineModule.class,
//    PetrolEngineModule.class  // cant use diesel and petrol  together here bcoz dagger wouldn't
    //know which engine to provide.
    //Advantage to create two engine modules from interface is that we can swap these modules
    //here and test it with mock module also easily.
})
public interface CarComponent {

    //provisional/getter method
    Car getCar();

    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        //defining api for car component builder our self.
        //this is used to create methods which we can call on
        //DaggerCarComponent.builder().methodDefinedHere()
        //to pass horse power directly into builder instead of
        //passing it in module such as DieselEngineModule such as
        //DaggerCarComponent.builder().dieselEngineModule((new DieselEngineModule(100))

        //In this DaggerCarComponent.builder().build(), both builder() and
        //build() methods are made by dagger . So now using this interface , we
        //to create build method manually.

        //Its only java builder pattern to create method to pass horse power.
        //Using this , we dont have to change petrolengine module and it remains
        //abstract not like diesel engine module where we are passing it as argument
        //and have to change things in module.
        //add same named annotation where we need these values
        //Now here instead of using named , we can create our own custom annotations
        //to avoid typo of names we pass in this @Named annotation.

        //With bindsInstance , we can get our values in dependency graph at runtime
        //which has same effect as passing the value in module and then providing it over provide
        //method but it is more efficient since dagger doesn't need to create instance of the
        //module.
        @BindsInstance
        Builder horsePower(@Named("horse power") int horsepower);

        @BindsInstance
        Builder engineCap(@Named("engine cap")int engineCap);

        //only declare not define since dagger will automatically create it.
        CarComponent build();

    }
}
