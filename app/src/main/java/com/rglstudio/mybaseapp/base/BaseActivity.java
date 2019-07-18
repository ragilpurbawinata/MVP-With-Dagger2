package com.rglstudio.mybaseapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rglstudio.mybaseapp.di.component.ActivityComponent;
import com.rglstudio.mybaseapp.di.component.DaggerActivityComponent;
import com.rglstudio.mybaseapp.di.module.ActivityModule;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
                .build();
        onInject(activityComponent);
    }

    public abstract void onInject(ActivityComponent activityComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
        }
    }

    protected void setUnbinder(Unbinder unbinder){
        this.unbinder = unbinder;
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
