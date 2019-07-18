package com.rglstudio.mybaseapp.api;

import com.rglstudio.mybaseapp.model.ResponPhoto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("photos")
    Observable<List<ResponPhoto>> getPhoto();
}
