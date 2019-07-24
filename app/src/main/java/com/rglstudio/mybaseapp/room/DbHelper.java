package com.rglstudio.mybaseapp.room;

import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class DbHelper implements DbRepository {
    private DbDao dbDao;

    @Inject
    public DbHelper(DbDao dbDao) {
        this.dbDao = dbDao;
    }

    @Override
    public void getAll(CallbackWithList<ResponData> callback) {
        dbDao.getAll()
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

    @Override
    public void insertAll(List<ResponData> list) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                dbDao.insertAll(list);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
