package com.demoapplication.starryskydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 星空漂浮自定义控件
 * Created by raoxuting on 2017/6/22.
 */

public class StarrySkyView extends View {

    private Bitmap backBitmap;//背景图

    private Bitmap earth;//地球

    private Bitmap jupiter;//木星

    private int backWidth;
    private int backHeight;

    private int earthWidth;
    private int earthHeight;

    private int jupiterWidth;
    private int jupiterHeight;

    public StarrySkyView(Context context) {
        this(context, null);
    }

    public StarrySkyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarrySkyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initBitmapInfo() {

        backBitmap = ((BitmapDrawable)getResources().
                getDrawable(R.mipmap.starry_sky)).getBitmap();
        backWidth = backBitmap.getWidth();
        backHeight = backBitmap.getHeight();

        earth = ((BitmapDrawable)getResources().
                getDrawable(R.mipmap.earth)).getBitmap();
        earthWidth = earth.getWidth();
        earthHeight = earth.getHeight();

        jupiter = ((BitmapDrawable)getResources().
                getDrawable(R.mipmap.jupiter)).getBitmap();
        jupiterWidth = jupiter.getWidth();
        jupiterHeight = jupiter.getHeight();

    }

    /**
     * 星球
     */
    private class StarInfo {

        // 缩放比例
        float sizePercent;
        // x位置
        int xLocation;
        // y位置
        int yLocation;
        // 透明度
        float alpha;
        // 漂浮方向
        int direction;
        // 漂浮速度
        int speed;
    }

    /**
     * 获取星球大小
     */
    private float getStarSize(float start, float end) {
        float nextFloat = (float) Math.random();
        if (start < nextFloat && nextFloat < end) {
            return nextFloat;
        } else {
            // 如果不处于想要的数据段，则再随机一次，因为不断递归有风险
            return (float) Math.random();
        }

    }


}
