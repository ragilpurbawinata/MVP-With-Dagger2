package com.rglstudio.mybaseapp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface DbDao {
    @Query("SELECT * FROM ResponData")
    Observable<List<ResponData>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ResponData> responData);
}
