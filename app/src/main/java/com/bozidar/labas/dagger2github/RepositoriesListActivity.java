package com.bozidar.labas.dagger2github;

import android.app.ListActivity;
import android.os.Bundle;

import com.bozidar.labas.dagger2github.api.GithubService;

import javax.inject.Inject;

public class RepositoriesListActivity extends ListActivity {

    @Inject
    GithubService githubService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerApplication.getComponent().inject(this);
        loadData();
    }

    private void loadData() {
    }
}
