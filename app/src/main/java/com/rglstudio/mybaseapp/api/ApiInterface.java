package com.rglstudio.mybaseapp.api;

import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("todos")
    Observable<List<ResponData>> getData();
}
