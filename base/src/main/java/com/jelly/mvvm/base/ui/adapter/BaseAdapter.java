package com.jelly.mvvm.base.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.jelly.mvvm.base.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 基类
 * 强烈建议优先使用RecyclerView.Adapter，因为BaseAdapter的getView方法可能执行多次
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
    protected String TAG = "BaseAdapter";
    protected List<T> mData = new ArrayList<>();

    public BaseAdapter() {
    }

    public BaseAdapter(List<T> mData) {
        if (!ListUtil.isEmpty(mData)) {
            this.mData = mData;
        }
    }

    @Override
    public int getCount() {
        if (ListUtil.isEmpty(mData)) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        if (ListUtil.isEmpty(mData)) {
            return null;
        }
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(getLayoutResId(getItemViewType(position)), null);
            viewHolder = onCreateViewHolder(parent, getItemViewType(position));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = convertView.getTag();
        }
        onBindViewHolder(viewHolder, position);
        return convertView;
    }

    protected abstract int getLayoutResId(int viewType);

    protected abstract Object onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    protected abstract void onBindViewHolder(@NonNull Object holder, int position);

    public void notifyData(List<T> data) {
        if (ListUtil.isEmpty(data)) {
            mData = new ArrayList<>();
        } else {
            mData = data;
        }
        notifyDataSetChanged();
    }
}