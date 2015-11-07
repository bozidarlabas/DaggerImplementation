package com.bozidar.labas.dagger2github.api;

import com.bozidar.labas.dagger2github.model.Repository;

import java.util.List;

import rx.Observable;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by Bozidar on 07.11.2015..
 */
public interface GithubService {
    @GET("/users/{user}/repos")
    @Headers("User-Agent: DaggerDemo")
    Observable<List<Repository>> listRepos(
            @Path("user") String user);

}