package com.bozidar.labas.storageexample.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bozidar.labas.storageexample.MyApplication;
import com.bozidar.labas.storageexample.R;
import com.bozidar.labas.storageexample.util.Constants;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentA extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;
    @Bind(R.id.input_text)
    EditText etInputText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.btn_store)
    public void storeTextToPreferences(){
        String text = etInputText.getText().toString().trim();
        if (!text.isEmpty()) {
            sharedPreferences.edit().putString(Constants.PREFS_INPUT, text).apply();
        }
    }

}
