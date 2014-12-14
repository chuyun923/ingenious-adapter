package com.chuyun.ingeniousadapter.model;

import android.widget.ImageView;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:上午9:55
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 *
 * 加载网络图片
 */
public interface ImageLoader {

    public void load(ImageView imageView,String imageUrl);

    //placeResId  默认图resid
    public void load(ImageView imageView,String imageUrl,int placeResId);
}
