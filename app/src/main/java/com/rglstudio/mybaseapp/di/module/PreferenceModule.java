package com.rglstudio.mybaseapp.di.module;

import com.rglstudio.mybaseapp.util.sharepreference.AppPreferenceHelper;
import com.rglstudio.mybaseapp.util.sharepreference.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferenceModule {
    @Singleton
    @Provides
    public PreferenceHelper providePreferenceHelper(AppPreferenceHelper appPreferenceHelper){
        return appPreferenceHelper;
    }
}
