package com.bozidar.labas.dagger2github;

import android.app.Application;

/**
 * Created by Bozidar on 06.11.2015..
 */
public class DaggerApplication extends Application {

    private static DaggerGraph graph;
    private static DaggerApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        buildComponentAndInject();
    }

    public static DaggerGraph getComponent() {
        return graph;
    }

    public static void buildComponentAndInject() {
        graph = DaggerDemoComponent.Initializer.init(INSTANCE);
    }
}
