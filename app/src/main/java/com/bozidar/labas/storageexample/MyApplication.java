package com.bozidar.labas.storageexample;

import android.app.Application;

import com.bozidar.labas.storageexample.component.DaggerStorageComponent;
import com.bozidar.labas.storageexample.component.StorageComponent;
import com.bozidar.labas.storageexample.modules.StorageModule;

/**
 * Created by macbook on 03.11.2015..
 */
public class MyApplication extends Application {

    private StorageComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerStorageComponent.builder().storageModule(new StorageModule(this)).build();
    }

    public StorageComponent getComponent(){
        return component;
    }
}
