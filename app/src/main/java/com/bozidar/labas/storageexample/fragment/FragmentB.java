package com.bozidar.labas.storageexample.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bozidar.labas.storageexample.MyApplication;
import com.bozidar.labas.storageexample.R;
import com.bozidar.labas.storageexample.util.Constants;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentB extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Bind(R.id.text_stored)
    TextView tvTextStored;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.btn_refresh)
    public void loadStoredDataIntoTextView(){
        String storedText = sharedPreferences.getString(Constants.PREFS_INPUT, "Nothing foud");
        tvTextStored.setText(storedText);
    }



}
