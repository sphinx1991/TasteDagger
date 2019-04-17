package com.ar.daggerapp;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

//@Module
//public abstract class DieselEngineModule {
//
//    //passing DieselEngine as argument since DieselEngine is annotated with
//    //@inject so dagger knows where to create it and get it from
////    @Provides
////    Engine provideEngine(PetrolEngine engine) {
////        return engine;
////    }
//
//    //Since above method will provide only DieselEngine and we need
//    //to write similar provides methods one ,two, three...times for petrol engine and
//    // other engines ,we use this below
//    //Here dagger also does not create its implementation under the hood
//    //and do not call this method, just instantiates the DieselEngine directly and returns
//    //It takes only a single argument .
//    //We cant use provides and binds together since its an abstract class and dagger doesn't
//    //create impl of this class also. But we can use static provides methods here.
//    @Binds
//    abstract Engine bindEngine(DieselEngine engine);
//
//    //static
//}

//we cant use above abstract class now since binds doesnt support any configuration
//or changing the object.
@Module
public class DieselEngineModule {

    //for this our module needs constructor to pass horse power from outside.
    //We can also create module for it but only if it used at other places also
    private int horsePower;

    //similarly we pass application context to create objects from it in real code.
    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    //now making this horsepower as provides, we can change provides Engine directly
    @Provides
    int provideHorsePower() {
        return horsePower;
    }

    //now this method we cant make it static since it depends on instance variable
    //;like discussed earlier.
//    @Provides
//    Engine providesEngine() {
//        return new DieselEngine(horsePower);
//    }

    //Since we are providing horse power separately so above commented.
    @Provides
    Engine providesEngine(DieselEngine engine) {
        return engine;
    }
}


