package com.rglstudio.mybaseapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.rglstudio.mybaseapp.model.ResponData;

@Database(entities = ResponData.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DbDao dbDao();
}
