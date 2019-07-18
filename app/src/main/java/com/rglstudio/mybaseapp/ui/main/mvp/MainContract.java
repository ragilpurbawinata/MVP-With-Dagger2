package com.rglstudio.mybaseapp.ui.main.mvp;

import com.rglstudio.mybaseapp.base.BaseMvpPresenter;
import com.rglstudio.mybaseapp.base.BaseMvpView;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponPhoto;

import java.util.List;

public interface MainContract {

    interface View extends BaseMvpView {
        void updateRecyclerView(List<ResponPhoto> list);
    }

    interface Presenter extends BaseMvpPresenter<View> {
        void getAll();
    }

    interface Interactor {
        void getAll(CallbackWithList<ResponPhoto> callback);
    }

}
