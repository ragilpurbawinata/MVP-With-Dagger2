package com.rglstudio.mybaseapp.ui.main.mvp;

import com.rglstudio.mybaseapp.base.BasePresenter;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements
        MainContract.Presenter {

    private MainContract.Interactor interactor;

    @Inject
    public MainPresenter(MainInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void getAll() {
        getMvpView().showLoading();
        interactor.getAll(new CallbackWithList<ResponData>() {
            @Override
            public void onSuccess(List<ResponData> list) {
                getMvpView().hideLoading();
                getMvpView().updateRecyclerView(list);
                getMvpView().saveToLocal(list);
            }

            @Override
            public void onFailed() {
                getMvpView().hideLoading();
            }

            @Override
            public void onError() {
                getMvpView().hideLoading();
            }

            @Override
            public void onComplete() {
                getMvpView().hideLoading();
            }
        });
    }
}
