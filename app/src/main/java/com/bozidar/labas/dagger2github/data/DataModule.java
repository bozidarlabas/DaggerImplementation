package com.bozidar.labas.dagger2github.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bozidar.labas.dagger2github.data.prefs.BooleanPreference;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Module
public class DataModule {

    static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences("dagger", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    @UseMockBackend
    BooleanPreference provideBooleanPreference(SharedPreferences sharedPreferences){
        return new BooleanPreference(sharedPreferences, "use_mock", false);
    }

    public static OkHttpClient createHttpClient(Application application){
        OkHttpClient client = new OkHttpClient();
        File cacheDir = new File(application.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        client.setCache(cache);
        return client;
    }
}
