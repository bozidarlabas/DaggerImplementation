package com.bozidar.labas.storageexample.component;

import com.bozidar.labas.storageexample.fragment.FragmentA;
import com.bozidar.labas.storageexample.fragment.FragmentB;
import com.bozidar.labas.storageexample.modules.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by macbook on 03.11.2015..
 */
@Singleton
@Component(modules = {StorageModule.class})
public interface StorageComponent {

    void inject(FragmentA fragmentA);

    void inject(FragmentB fragmentB);
}
