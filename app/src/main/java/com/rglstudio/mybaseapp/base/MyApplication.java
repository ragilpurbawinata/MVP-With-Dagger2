package com.rglstudio.mybaseapp.base;

import android.app.Application;

import com.rglstudio.mybaseapp.di.component.ApplicationComponent;
import com.rglstudio.mybaseapp.di.component.DaggerApplicationComponent;
import com.rglstudio.mybaseapp.di.module.ApplicationModule;

public class MyApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
