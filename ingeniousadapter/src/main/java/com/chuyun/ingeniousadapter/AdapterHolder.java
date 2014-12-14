package com.chuyun.ingeniousadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chuyun.ingeniousadapter.model.DefaultAdapterConfig;
import com.chuyun.ingeniousadapter.model.ImageLoader;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:上午8:44
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public class AdapterHolder {
    private final SparseArray<View> views;

    private final Context context;

    private int position;

    private View convertView;

    private static ImageLoader imageLoader;

    static {
        DefaultAdapterConfig defaultAdapterConfig = DefaultAdapterConfig.getInstance();
        imageLoader = defaultAdapterConfig.getImageLoader();
    }

    /**
     * 创建一个Holder
     * @param context
     * @param parent
     * @param layoutId
     * @param position
     */
    private AdapterHolder(Context context, ViewGroup parent, int layoutId, int position) {

        this.context = context;
        this.position = position;
        this.views = new SparseArray<View>();
        convertView = LayoutInflater.from(context)
                .inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    public static AdapterHolder get(Context context, View convertView,ViewGroup parent, int layoutId, int position) {
        if(convertView == null) {
            return new AdapterHolder(context,parent,layoutId,position);
        }
        //复用现有的Holder
        AdapterHolder adapterHolder = (AdapterHolder) convertView.getTag();
        adapterHolder.position = position;
        return adapterHolder;
    }



    public View getConvertView() {
        return convertView;
    }

    /**
     * 获取当前layout中指定id的View,在Holder中定义了许多常用的操作，如：通过setText(viewId,value)
     * 设置指定id的textview的文字
     * 如果不能包含你所需要的操作，请 getView(ViewId).set***(value)
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        return retrieveView(viewId);
    }

    //region 常用操作

    //region common
    public AdapterHolder setBackgroundColor(int viewId, int color) {
        View view = retrieveView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public AdapterHolder setBackgroundResource(int viewId,int resourceId) {
        View view = retrieveView(viewId);
        view.setBackgroundResource(resourceId);
        return this;
    }

    public AdapterHolder setVisibility(int viewId,int visibility) {
        View view = retrieveView(viewId);
        if(view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
        return this;
    }

    public AdapterHolder setTag(int viewId,Object tag) {
        View view = retrieveView(viewId);
        view.setTag(tag);
        return this;
    }

    public AdapterHolder setTag(int viewId,int key,Object tag) {
        View view = retrieveView(viewId);
        view.setTag(key,tag);
        return this;
    }

    public AdapterHolder setOnClickListener(int viewId,View.OnClickListener onClickListener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(onClickListener);
        return this;
    }

    public AdapterHolder setOnTouchListener(int viewId,View.OnTouchListener onTouchListener) {
        View view = retrieveView(viewId);
        view.setOnTouchListener(onTouchListener);
        return this;
    }

    public AdapterHolder setOnLongClickListener(int viewId,View.OnLongClickListener onLongClickListener) {
        View view = retrieveView(viewId);
        view.setOnLongClickListener(onLongClickListener);
        return this;
    }

    public AdapterHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            retrieveView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            retrieveView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public AdapterHolder setAdapter(int viewId,Adapter adapter) {
        AdapterView adapterView = retrieveView(viewId);
        adapterView.setAdapter(adapter);
        return this;
    }

    //endregion

    //region ImageView
    public AdapterHolder setImageResource(int viewId, int imageResId) {
        ImageView view = retrieveView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public AdapterHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = retrieveView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public AdapterHolder setImageUrl(int viewId, String imageUrl) {
        ImageView view = retrieveView(viewId);
        imageLoader.load(view,imageUrl);
        return this;
    }

    public AdapterHolder setImageUrlWithPlaceHolder(int viewId,String imageUrl,int placeResId) {
        ImageView view = retrieveView(viewId);
        imageLoader.load(view,imageUrl,placeResId);
        return this;
    }

    public AdapterHolder setImageBitmap(int viewId,Bitmap bitmap) {
        ImageView view = retrieveView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
    //endregion

    //region TextView
    public AdapterHolder setText(int viewId, String value) {
        TextView view = retrieveView(viewId);
        view.setText(value);
        return this;
    }

    public AdapterHolder setTextColor(int viewId, int textColor) {
        TextView view = retrieveView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public AdapterHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = retrieveView(viewId);
        view.setTextColor(context.getResources().getColor(textColorRes));
        return this;
    }

    public AdapterHolder setTextSize(int viewId, float size) {
        TextView view = retrieveView(viewId);
        view.setTextSize(size);
        return this;
    }

    //endregion

    //region ProgressBar
    public AdapterHolder setProgress(int viewId, int progress) {
        ProgressBar view = retrieveView(viewId);
        view.setProgress(progress);
        return this;
    }

    public AdapterHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    //endregion

    //endregion

    /** Retrieve the convertView */
    public View getView() {
        return convertView;
    }



    public int getPosition() {
        return position;
    }

    /**
     * 根据id，从layout取出指定类型的View
     * @param viewId
     * @param <T>
     * @return
     */
    private <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
