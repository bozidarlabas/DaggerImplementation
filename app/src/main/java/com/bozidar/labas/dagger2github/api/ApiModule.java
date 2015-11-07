package com.bozidar.labas.dagger2github.api;

import android.app.Application;

import com.bozidar.labas.dagger2github.data.DataModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    Client provideClient(Application application){
        return new OkClient(DataModule.createHttpClient(application));
    }

    /*
    BaseUrl object is delivered by child module (Release or Debug)
     */
    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, Client client) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint)
                .build();
    }



}
