package com.rglstudio.mybaseapp.base;

import android.app.Application;

import com.rglstudio.mybaseapp.di.component.ApplicationComponent;
import com.rglstudio.mybaseapp.di.component.DaggerApplicationComponent;
import com.rglstudio.mybaseapp.di.module.ApplicationModule;
import com.rglstudio.mybaseapp.di.module.RoomModule;

public class MyApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
