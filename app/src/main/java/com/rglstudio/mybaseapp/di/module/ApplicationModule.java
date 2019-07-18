package com.rglstudio.mybaseapp.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Context context;

    public ApplicationModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    public Context provideApplicationContext() {
        return this.context;
    }
}
