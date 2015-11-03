package com.bozidar.labas.daggersimpleexample.model;

import javax.inject.Inject;

/**
 * Created by Bozidar on 03.11.2015..
 */
public class Vehicle {
    private Motor motor;

    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int value) {
        motor.accelerate(value);
    }

    public void stop() {
        motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }
}

//Vehicle is dependent class
