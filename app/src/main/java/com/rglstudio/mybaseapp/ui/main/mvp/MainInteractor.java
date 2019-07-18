package com.rglstudio.mybaseapp.ui.main.mvp;

import com.rglstudio.mybaseapp.api.ApiInterface;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponPhoto;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainInteractor implements MainContract.Interactor {

    private ApiInterface apiInterface;

    @Inject
    public MainInteractor(ApiInterface apiInterface){
        this.apiInterface = apiInterface;
    }

    @Override
    public void getAll(CallbackWithList<ResponPhoto> callback) {
        apiInterface.getPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ResponPhoto>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ResponPhoto> list) {
                        callback.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
