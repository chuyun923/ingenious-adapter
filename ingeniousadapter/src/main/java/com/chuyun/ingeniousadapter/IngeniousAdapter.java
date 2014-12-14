package com.chuyun.ingeniousadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:下午1:26
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public abstract class IngeniousAdapter<T> extends BaseAdapter {
    private Context context;
    private List<T> data;
    private final int[] layouts;


    public IngeniousAdapter(Context context) {
        this(context,null);
    }

    public IngeniousAdapter(Context context,List<T> list) {
        this.data = list!=null?list:new ArrayList();
        this.context = context;
        layouts = assignLayoutIDs();
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
    }

    @Override
    public int getViewTypeCount() {
        return layouts==null?0:layouts.length;
    }

    @Override
    public T getItem(int position) {
        if(position>=0 && position<data.size()) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        AdapterHolder adapterHolder = AdapterHolder.get(context,convertView,parent,layouts[type],position);
        convert(adapterHolder,getItem(position),getItemViewType(position));
        return adapterHolder.getView();
    }

    /**
     * 通过Holder填充view的属性
     *
     * holder
     * item
     */
    protected abstract void convert(AdapterHolder holder, T item,int viewType);

    /**
     * layoutid至数据类型的映射,插入顺序对应itemviewtype
     * @return
     */
    protected abstract int[] assignLayoutIDs();
}
