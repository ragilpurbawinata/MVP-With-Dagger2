package com.rglstudio.mybaseapp.di.module;

import android.app.Application;

import androidx.room.Room;

import com.rglstudio.mybaseapp.room.AppDatabase;
import com.rglstudio.mybaseapp.room.DbDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private AppDatabase demoDatabase;

    public RoomModule(Application mApplication) {
        demoDatabase = Room
                .databaseBuilder(mApplication, AppDatabase.class, "demo-db")
                .build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Provides
    @Singleton
    public DbDao provideRoomDao(AppDatabase appDatabase) {
        return appDatabase.dbDao();
    }
}
