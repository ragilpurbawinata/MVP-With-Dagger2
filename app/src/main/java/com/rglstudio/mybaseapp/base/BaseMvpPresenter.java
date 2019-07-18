package com.rglstudio.mybaseapp.base;

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
