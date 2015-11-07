package com.bozidar.labas.dagger2github;

import android.app.ListActivity;
import android.os.Bundle;

public class RepositoriesListActivity extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerApplication.getComponent().inject(this);
        loadData();
    }

    private void loadData() {

    }
}
