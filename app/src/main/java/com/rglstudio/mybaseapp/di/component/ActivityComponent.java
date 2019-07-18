package com.rglstudio.mybaseapp.di.component;

import com.rglstudio.mybaseapp.ui.main.MainActivity;
import com.rglstudio.mybaseapp.di.module.ActivityModule;
import com.rglstudio.mybaseapp.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
