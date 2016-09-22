package com.mbg.nineimageview;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public abstract class NineImageViewAdapter<T> {
    protected abstract void onDisplayImage(Context context, ImageView imageView, T t);


    protected void onItemImageClick(Context context, int index, List<T> list) {
    }

    protected int setDefaultbackGround(){
        return R.color.gray;
    }

    protected int[] getImageSize(T data,int defaultSize){
        return new int[]{defaultSize,defaultSize};
    }



    protected ImageView generateImageView(Context context) {
        GridImageView imageView = new GridImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundResource(setDefaultbackGround());
        return imageView;
    }
}
