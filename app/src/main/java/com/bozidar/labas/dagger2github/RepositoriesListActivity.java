package com.bozidar.labas.dagger2github;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.bozidar.labas.dagger2github.api.GithubService;
import com.bozidar.labas.dagger2github.model.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        githubService.listRepos("BozidarLabas")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Repository>>() {
                    @Override
                    public void call(List<Repository> repositories) {
                        List<String> names = new ArrayList<String>();
                        for (Repository repository : repositories) {
                            names.add(repository.getName());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RepositoriesListActivity.this, android.R.layout.simple_expandable_list_item_1, names);
                        setListAdapter(adapter);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("RepositoriesList", "Error receiving list of repos", throwable);
                    }
                });
    }
}
