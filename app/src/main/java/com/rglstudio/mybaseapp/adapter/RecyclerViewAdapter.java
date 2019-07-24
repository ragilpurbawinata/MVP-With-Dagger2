package com.rglstudio.mybaseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rglstudio.mybaseapp.R;
import com.rglstudio.mybaseapp.model.ResponData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    private List<ResponData> listData;

    public RecyclerViewAdapter() {
        listData = new ArrayList<>();
    }

    public List<ResponData> getList() {
        return listData;
    }

    public void setList(List<ResponData> list) {
        if (!listData.isEmpty()){
            listData.clear();
        }
        listData.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ResponData data = listData.get(position);

        holder.author.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.author)
        TextView author;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
