package com.ar.daggerapp;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PetrolEngineModule {

    //passing petrolengine as argument since Pertrolengine is annotated with
    //@inject so dagger knows where to create it and get it from
//    @Provides
//    Engine provideEngine(PetrolEngine engine) {
//        return engine;
//    }

    //Since above method will provide only petrol engine and we need
    //to write similar provides methods one ,two, three...times for diesel engine and
    // other engines ,we use this below
    //Here dagger also does not create its implementation under the hood
    //and do not call this method, just instantiates the petrol engine directly and returns
    //It takes only a single argument .
    //We cant use provides and binds together since its an abstract class and dagger doesnt
    //create impl of this class also. But we can use static provides methods here.
    @Binds
    abstract Engine bindEngine(PetrolEngine engine);

    //static
}
