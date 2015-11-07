package com.bozidar.labas.dagger2github;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bozidar.labas.dagger2github.data.UseMockBackend;
import com.bozidar.labas.dagger2github.data.prefs.BooleanPreference;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_checkbox)
    CheckBox checkBox;

    @Bind(R.id.main_tv_text)
    TextView text;

    @Inject
    Resources resources;

    @Inject
    @UseMockBackend
    BooleanPreference useMock;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        injectDemoComponent();
    }

    private void injectDemoComponent() {
        DaggerApplication.getComponent().inject(this);
        text.setText(resources.getString(R.string.injected_text));
        checkBox.setChecked(useMock.get());
    }

    @OnCheckedChanged(R.id.main_checkbox)
    public void rememberMe(CompoundButton button, boolean checked){
        useMock.set(checked);

        // Need to rebuild graph because of changed settings which directly influences object creation (mock mode)
        DaggerApplication.buildComponentAndInject();
    }

    @OnClick(R.id.goToRepositoriesList)
    public void goToRepositoriesList(){
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }
}
