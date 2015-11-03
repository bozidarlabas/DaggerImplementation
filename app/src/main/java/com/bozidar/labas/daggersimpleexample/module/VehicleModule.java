package com.bozidar.labas.daggersimpleexample.module;

import com.bozidar.labas.daggersimpleexample.model.Motor;
import com.bozidar.labas.daggersimpleexample.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by macbook on 03.11.2015..
 */
@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}

//@Module - for the classes whose methods provides dependencies
//@Provides - for the methods within @Module classes