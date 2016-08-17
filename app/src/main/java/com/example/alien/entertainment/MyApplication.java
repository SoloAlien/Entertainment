package com.example.alien.entertainment;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by Alien on 2016/8/17.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
    }

    private void initImageLoader() {
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)//设置硬盘缓存
                .cacheInMemory(true)//设置内存缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置加载时图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//设置空连接的图片
                .showImageOnFail(R.mipmap.ic_launcher)//设置失败的图片
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片缩放大小，此处设置为缩放到目标大小
                .build();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .memoryCacheSize(5*1024*1024)//设置缓存大小
                .memoryCacheExtraOptions(480,800)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
