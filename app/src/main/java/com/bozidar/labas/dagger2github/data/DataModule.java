package com.bozidar.labas.dagger2github.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Module
public class DataModule {
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences("dagger", Context.MODE_PRIVATE);
    }
}
