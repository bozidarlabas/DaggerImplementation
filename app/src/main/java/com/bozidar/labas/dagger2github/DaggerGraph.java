package com.bozidar.labas.dagger2github;

/**
 * Created by Bozidar on 06.11.2015..
 */
public interface DaggerGraph {
    void inject(MainActivity mainActivity);
    void inject(RepositoriesListActivity repositoriesListActivity);
}
