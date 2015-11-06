package com.bozidar.labas.dagger2github;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Module
public class MainModule {
    private final DaggerApplication application;

    public MainModule(DaggerApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    protected Resources provideResources(){
        return application.getResources();
    }
}
