package com.bozidar.labas.dagger2github;

import com.bozidar.labas.dagger2github.api.ReleaseApiModule;
import com.bozidar.labas.dagger2github.data.ReleaseDataModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bozidar on 07.11.2015..
 */
@Singleton
@Component(modules = {
        MainModule.class,
        ReleaseApiModule.class,
        ReleaseDataModule.class
})
public interface DaggerDemoComponent extends DaggerGraph{
    static final class Initializer {
        private Initializer() {}

        public static DaggerDemoComponent init(DaggerApplication application){
            return DaggerDaggerDemoComponent.builder().mainModule(new MainModule(application))
                    .build();
        }
    }
}
