package com.rglstudio.mybaseapp.ui.main.mvp;

import com.rglstudio.mybaseapp.api.ApiInterface;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;

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
    public void getAll(CallbackWithList<ResponData> callback) {
        apiInterface.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ResponData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ResponData> list) {
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
