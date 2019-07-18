package com.rglstudio.mybaseapp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    private BaseActivity baseActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity){
            BaseActivity baseActivity = (BaseActivity) context;
            this.baseActivity = baseActivity;
            onInject(baseActivity);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view, savedInstanceState);
    }

    public abstract void setUp(View view, Bundle savedInstanceState);

    public abstract void onInject(BaseActivity baseActivity);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }

}
