package com.rglstudio.mybaseapp.ui.main.mvp;

import com.rglstudio.mybaseapp.base.BaseMvpPresenter;
import com.rglstudio.mybaseapp.base.BaseMvpView;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;

import java.util.List;

public interface MainContract {

    interface View extends BaseMvpView {
        void updateRecyclerView(List<ResponData> list);
        void saveToLocal(List<ResponData> list);
    }

    interface Presenter extends BaseMvpPresenter<View> {
        void getAll();
    }

    interface Interactor {
        void getAll(CallbackWithList<ResponData> callback);
    }

}
