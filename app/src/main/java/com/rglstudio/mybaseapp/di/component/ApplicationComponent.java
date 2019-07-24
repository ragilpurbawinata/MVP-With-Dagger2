package com.rglstudio.mybaseapp.di.component;

import com.rglstudio.mybaseapp.api.ApiInterface;
import com.rglstudio.mybaseapp.di.module.ApplicationModule;
import com.rglstudio.mybaseapp.di.module.NetworkModule;
import com.rglstudio.mybaseapp.di.module.PreferenceModule;
import com.rglstudio.mybaseapp.di.module.RoomModule;
import com.rglstudio.mybaseapp.room.AppDatabase;
import com.rglstudio.mybaseapp.room.DbDao;
import com.rglstudio.mybaseapp.room.DbHelper;
import com.rglstudio.mybaseapp.util.sharepreference.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, PreferenceModule.class, NetworkModule.class, RoomModule.class})
public interface ApplicationComponent {
    PreferenceHelper preferenceHelper();

    ApiInterface articleApi();

    AppDatabase appDatabase();

    DbDao dbDao();

    DbHelper dbHelper();
}
