package com.jelly.mvvm.base.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 基类
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected String TAG = "BaseViewHolder";

    public BaseViewHolder(@NonNull ViewGroup parent, int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        TAG = getClass().getSimpleName();
    }
}