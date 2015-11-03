package com.bozidar.labas.daggersimpleexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bozidar.labas.daggersimpleexample.component.DaggerVehicleComponent;
import com.bozidar.labas.daggersimpleexample.component.VehicleComponent;
import com.bozidar.labas.daggersimpleexample.model.Vehicle;
import com.bozidar.labas.daggersimpleexample.module.VehicleModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Inject
    Vehicle vehicle;

    @Bind(R.id.current_speed_value)
    TextView tvSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        component.inject(this);
        tvSpeed.setText(String.valueOf(vehicle.getSpeed()));
    }

    @OnClick(R.id.brake)
    public void callBrake(){
        vehicle.stop();
        tvSpeed.setText(String.valueOf(vehicle.getSpeed()));
    }

    @OnClick(R.id.increase)
    public void callIncrease(){
        vehicle.increaseSpeed(10);
        tvSpeed.setText(String.valueOf(vehicle.getSpeed()));
    }
}
