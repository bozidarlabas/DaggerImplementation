package com.bozidar.labas.dagger2.github.api;

import com.bozidar.labas.dagger2github.api.ApiModule;
import com.bozidar.labas.dagger2github.api.GithubService;
import com.bozidar.labas.dagger2github.data.UseMockBackend;
import com.bozidar.labas.dagger2github.data.prefs.BooleanPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

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


    /**
     * Check if mock service is turned on, if it is return mockservice, else return service
     */
    @Provides
    @Singleton
    GithubService provideGithubService(RestAdapter restAdapter, MockRestAdapter mockRestAdapter, GithubServiceMock githubServiceMock,
                                       @UseMockBackend BooleanPreference useMockMode){
        if(useMockMode.get()){
            return mockRestAdapter.create(GithubService.class, githubServiceMock);
        }else{
            return restAdapter.create(GithubService.class);
        }
    }

    @Provides
    @Singleton
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter){
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        return mockRestAdapter;
    }

}
