package com.library.okgo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.library.okgo.R;
import com.lzy.imagepicker.loader.ImageLoader;
import com.lzy.ninegrid.NineGridView;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * ================================================
 * 作    者：//（qizfeng）Github地址：https://github.com/qizfeng1991
 * 版    本：1.0
 * 创建日期：16/9/1
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class PicassoImageLoader implements ImageLoader
        , NineGridView.ImageLoader
{

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        Picasso.with(activity)                                  //配置上下文
                .load(Uri.fromFile(new File(path)))             //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .error(R.drawable.c1_image1)             //设置错误图片
                .placeholder(R.drawable.c1_image1)       //设置占位图片
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }

    @Override
    public void onDisplayImage(Context context, ImageView imageView, String url) {
        Picasso.with(context).load(url)//
                .placeholder(R.drawable.c1_image1)//
                .error(R.drawable.c1_image1)//
                .into(imageView);
    }

    @Override
    public Bitmap getCacheImage(String url) {
        return null;
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }
}
