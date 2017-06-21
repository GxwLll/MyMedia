package com.gxw.mymedia.base;

import android.content.Context;
import android.view.LayoutInflater;


import com.gxw.mymedia.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected List<T> mList;
    protected LayoutInflater mInflater;
    protected Context mContext;

    public BaseAdapter(Context context) {
        mList = new ArrayList<T>();
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
    }

    public void clearData() {
        mList.clear();
    }

    public void addAllData(List<T> list) {
        if (!ListUtil.isEmpty(list)) {
            mList.addAll(list);
        }
    }

    public void setList(List<T> list){
            mList=list;
    	this.notifyDataSetChanged();
    }
    
    public void addAllDataAndNorify(List<T> list) {
        this.addAllData(list);
        this.notifyDataSetChanged();
    }

    public List<T> getData() {
        return mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
