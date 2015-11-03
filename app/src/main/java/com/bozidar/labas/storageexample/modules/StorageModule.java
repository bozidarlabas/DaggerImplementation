package com.bozidar.labas.storageexample.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bozidar.labas.storageexample.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by macbook on 03.11.2015..
 */
@Module
public class StorageModule {
    private final MyApplication application;

    public StorageModule(MyApplication application){
        this.application = application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
