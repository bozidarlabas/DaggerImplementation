package com.bozidar.labas.dagger2github.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

/**
 * Created by Bozidar on 07.11.2015..
 */
@Module(includes = {ApiModule.class})
public class ReleaseApiModule {
    private String RELEASE_API_URL = "https://api.github.com";

    @Provides
    @Singleton
    Endpoint provideEndpoint(){
        return Endpoints.newFixedEndpoint(RELEASE_API_URL);
    }

    @Provides
    @Singleton
    GithubService provideGithubService(RestAdapter restAdapter){
        return restAdapter.create(GithubService.class);
    }
}
