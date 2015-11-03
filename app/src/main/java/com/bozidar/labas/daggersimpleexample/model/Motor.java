package com.bozidar.labas.daggersimpleexample.model;

/**
 * Created by Bozidar on 03.11.2015..
 */
public class Motor {
    private int rpm;

    public Motor(){
        this.rpm = 0;
    }

    public int getRpm(){
        return rpm;
    }

    public void accelerate(int value){
        rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}

//Motor is independent class