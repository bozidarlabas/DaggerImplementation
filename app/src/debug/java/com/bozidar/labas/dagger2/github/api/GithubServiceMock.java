package com.bozidar.labas.dagger2.github.api;

import com.bozidar.labas.dagger2github.api.GithubService;
import com.bozidar.labas.dagger2github.model.Repository;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Bozidar on 07.11.2015..
 */
public class GithubServiceMock implements GithubService{
    @Inject
    public GithubServiceMock() {
    }
    @Override
    public Observable<List<Repository>> listRepos(@Path("org") String org) {
        return Observable.just(Arrays.asList(
                createMockRepository("Data 1"),
        createMockRepository("Data 2"),
        createMockRepository("Data 3")
        ));
    }

    private Repository createMockRepository(String name){
        Repository repositoryMocked = new Repository();
        repositoryMocked.setName(name);
        return repositoryMocked;
    }
}
