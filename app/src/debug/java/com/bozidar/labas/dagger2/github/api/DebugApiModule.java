package com.bozidar.labas.dagger2.github.api;

import com.bozidar.labas.dagger2github.api.ApiModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Module(includes = {ApiModule.class})
public class DebugApiModule {
    private String DEBUG_API_URL = "https://api.github.com";

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(DEBUG_API_URL);
    }



}
