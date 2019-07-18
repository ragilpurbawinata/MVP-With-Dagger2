package com.rglstudio.mybaseapp.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private WeakReference<V> mvpView;

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = new WeakReference<V>(mvpView);
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
    }

    protected V getMvpView() {
        return this.mvpView.get();
    }
}
