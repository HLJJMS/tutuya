package com.tutuya.tck.bean.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.bean.network.HomeBannerBean;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(String.valueOf(path)).into(imageView);
    }
}
