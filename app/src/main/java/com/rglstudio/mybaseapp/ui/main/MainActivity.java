package com.rglstudio.mybaseapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rglstudio.mybaseapp.R;
import com.rglstudio.mybaseapp.adapter.RecyclerViewAdapter;
import com.rglstudio.mybaseapp.base.BaseActivity;
import com.rglstudio.mybaseapp.di.component.ActivityComponent;
import com.rglstudio.mybaseapp.model.ResponPhoto;
import com.rglstudio.mybaseapp.ui.main.mvp.MainContract;
import com.rglstudio.mybaseapp.ui.main.mvp.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{
    @Inject
    MainPresenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView rv;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnbinder(ButterKnife.bind(this));

        presenter.onAttach(this);
        presenter.getAll();

        adapter = new RecyclerViewAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.setAdapter(adapter);
    }

    @Override
    public void onInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void updateRecyclerView(List<ResponPhoto> list) {
        adapter.setList(list);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
