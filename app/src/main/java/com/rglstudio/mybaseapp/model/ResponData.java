package com.rglstudio.mybaseapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class ResponData {
    @PrimaryKey(autoGenerate = true)
    private int idTabel;

    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    @Expose
    private Integer userId;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @ColumnInfo(name = "completed")
    @SerializedName("completed")
    @Expose
    private Boolean completed;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public int getIdTabel() {
        return idTabel;
    }

    public void setIdTabel(int idTabel) {
        this.idTabel = idTabel;
    }
}
