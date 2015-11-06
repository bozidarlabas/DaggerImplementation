package com.bozidar.labas.dagger2.github;

import com.bozidar.labas.dagger2.github.data.DebugDataModule;
import com.bozidar.labas.dagger2github.DaggerApplication;
import com.bozidar.labas.dagger2github.DaggerGraph;
import com.bozidar.labas.dagger2github.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Singleton
@Component(modules = {
        MainModule.class,
        DebugDataModule.class
})
public interface DaggerDemoComponent extends DaggerGraph {
    static final class Initializer {
        private Initializer() {
        }

        public static DaggerDemoComponent init(DaggerApplication application) {
            return DaggerDaggerDemoComponent.builder().mainModule(new MainModule(application)).build();
        }
    }
}