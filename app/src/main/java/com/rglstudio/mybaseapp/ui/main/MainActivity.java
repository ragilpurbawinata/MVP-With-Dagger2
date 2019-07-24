package com.rglstudio.mybaseapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rglstudio.mybaseapp.R;
import com.rglstudio.mybaseapp.adapter.RecyclerViewAdapter;
import com.rglstudio.mybaseapp.base.BaseActivity;
import com.rglstudio.mybaseapp.di.component.ActivityComponent;
import com.rglstudio.mybaseapp.listener.CallbackWithList;
import com.rglstudio.mybaseapp.model.ResponData;
import com.rglstudio.mybaseapp.room.DbHelper;
import com.rglstudio.mybaseapp.ui.main.mvp.MainContract;
import com.rglstudio.mybaseapp.ui.main.mvp.MainPresenter;
import com.rglstudio.mybaseapp.util.InternetUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{
    @Inject
    MainPresenter presenter;
    @Inject
    DbHelper dbHelper;

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

        adapter = new RecyclerViewAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.setAdapter(adapter);

        if (InternetUtil.checkInternetConnection(this)) {
            presenter.getAll();
        }
        else {
            dbHelper.getAll(new CallbackWithList<ResponData>() {
                @Override
                public void onSuccess(List<ResponData> list) {
                    adapter.setList(list);
                }

                @Override
                public void onFailed() {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    @Override
    public void onInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void updateRecyclerView(List<ResponData> list) {
        adapter.setList(list);
    }

    @Override
    public void saveToLocal(List<ResponData> list) {
        dbHelper.insertAll(list);
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
