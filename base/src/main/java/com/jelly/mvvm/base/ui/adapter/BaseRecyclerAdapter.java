package com.jelly.mvvm.base.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jelly.mvvm.base.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 基类
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {
    protected String TAG = "BaseRecyclerAdapter";
    protected List<T> mData = new ArrayList<>();

    public BaseRecyclerAdapter() {
    }

    public BaseRecyclerAdapter(List<T> mData) {
        if (!ListUtil.isEmpty(mData)) {
            this.mData = mData;
        }
    }

    @Override
    public int getItemCount() {
        if (ListUtil.isEmpty(mData)) {
            return 0;
        }
        return mData.size();
    }

    public void notifyData(List<T> data) {
        if (ListUtil.isEmpty(data)) {
            mData = new ArrayList<>();
        } else {
            mData = data;
        }
        notifyDataSetChanged();
    }
}