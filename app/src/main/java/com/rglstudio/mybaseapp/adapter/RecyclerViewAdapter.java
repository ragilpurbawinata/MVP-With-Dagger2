package com.rglstudio.mybaseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rglstudio.mybaseapp.R;
import com.rglstudio.mybaseapp.model.ResponPhoto;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    private List<ResponPhoto> listPhoto;

    public RecyclerViewAdapter() {
        listPhoto = new ArrayList<>();
    }

    public List<ResponPhoto> getList() {
        return listPhoto;
    }

    public void setList(List<ResponPhoto> list) {
        if (!listPhoto.isEmpty()){
            listPhoto.clear();
        }
        listPhoto.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ResponPhoto photo = listPhoto.get(position);
        Glide.with(holder.imageView.getContext())
                .load(photo.getThumbnailUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pic);
        }
    }
}
