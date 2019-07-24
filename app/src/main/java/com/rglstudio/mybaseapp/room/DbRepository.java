package com.rglstudio.mybaseapp.room;

import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

public interface DbRepository {
    void getAll(CallbackWithList<ResponData> callback);

    void insertAll(List<ResponData> list);
}
