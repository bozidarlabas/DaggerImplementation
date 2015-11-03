package com.bozidar.labas.daggersimpleexample.component;

import com.bozidar.labas.daggersimpleexample.MainActivity;
import com.bozidar.labas.daggersimpleexample.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bozidar on 03.11.2015..
 */
@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    void inject(MainActivity mainActivity);
}

//@Component -  Bridge interface between modules and injection