package com.rglstudio.mybaseapp.listener;
import java.util.List;

public interface CallbackWithList<T> {
    void onSuccess(List<T> list);
    void onFailed();
    void onError();
    void onComplete();
}
