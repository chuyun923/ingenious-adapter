package com.chuyun.ingeniousadapter.model;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:上午10:07
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public class DefaultAdapterConfig implements AdapterConfig {
    private static final DefaultAdapterConfig instance = new DefaultAdapterConfig();
    private static ImageLoader mImageLoader;

    public static DefaultAdapterConfig getInstance() {
        return instance;
    }
    @Override
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public static void setImageLoader(ImageLoader mImageLoader) {
        DefaultAdapterConfig.mImageLoader = mImageLoader;
    }
}
