package com.chuyun.example;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.chuyun.ingeniousadapter.model.DefaultAdapterConfig;
import com.chuyun.ingeniousadapter.model.ImageLoader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Author:彭亮
 * Date:14-12-14
 * Time:下午7:34
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public class ExamApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DefaultAdapterConfig.setImageLoader(new ImageLoaderImpl());
    }

    private class ImageLoaderImpl implements ImageLoader{
        Context context = ExamApplication.this.getApplicationContext();
        File cacheDir = context.getExternalCacheDir() == null ? context.getCacheDir() : context.getExternalCacheDir();
        File cache = new File(cacheDir, "images");
        private  Picasso picasso = new Picasso.Builder(context).downloader(new OkHttpDownloader(cache)).build();


        @Override
        public void load(ImageView imageView, String imageUrl) {
            picasso.load(imageUrl).into(imageView);
        }

        @Override
        public void load(ImageView imageView, String imageUrl, int placeResId) {
            picasso.load(imageUrl).placeholder(placeResId).into(imageView);
        }
    }
}
