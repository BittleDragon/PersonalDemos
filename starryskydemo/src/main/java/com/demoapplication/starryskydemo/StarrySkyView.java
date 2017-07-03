package com.demoapplication.starryskydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Random;

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

    private int mFloatTransLowSpeed;
    private int mFloatTransMidSpeed;
    private int mFloatTransFastSpeed;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int TOP = 2;
    private static final int BOTTOM = 3;

    private int mStarCount = 8;

    private static final float[][] STAR_LOCATION = new float[][] {
            {0.5f, 0.2f}, {0.68f, 0.35f}, {0.5f, 0.05f},
            {0.15f, 0.15f}, {0.5f, 0.5f}, {0.15f, 0.8f},
            {0.2f, 0.3f}, {0.77f, 0.4f}, {0.75f, 0.5f},
            {0.8f, 0.55f}, {0.9f, 0.6f}, {0.1f, 0.7f},
            {0.1f, 0.1f}, {0.7f, 0.8f}, {0.5f, 0.6f}
    };

    private List<StarInfo> mStarInfos;

    private int mTotalWidth;
    private int mTotalHeight;

    public StarrySkyView(Context context) {
        this(context, null);
    }

    public StarrySkyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarrySkyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initBitmapInfo();

        //初始化三种星球移动速度
        mFloatTransLowSpeed = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.5f,
                getResources().getDisplayMetrics());
        mFloatTransMidSpeed = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.75f,
                getResources().getDisplayMetrics());
        mFloatTransFastSpeed = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f,
                getResources().getDisplayMetrics());

        mTotalWidth = getResources().getDisplayMetrics().widthPixels;
        mTotalHeight = getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 初始化星球位图
     */
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

    /**
     * 初始化星球运行方向
     */
    private int getStarDirection() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        int direction = 0;
        switch (randomInt) {
            case 0:
                direction = LEFT;
                break;
            case 1:
                direction = RIGHT;
                break;
            case 2:
                direction = TOP;
                break;
            case 3:
                direction = BOTTOM;
                break;
        }
        return direction;
    }

    /**
     * 初始化星球信息
     */
    private void initStarInfo() {

        StarInfo starInfo = null;
        Random random = new Random();
        for (int i = 0; i < mStarCount; i++) {
            // 获取星球大小比例
            float starSize = getStarSize(0.4f, 0.9f);
            // 初始化星球大小
            float[] starLocation = STAR_LOCATION[i];
            starInfo = new StarInfo();
            starInfo.sizePercent = starSize;

            // 初始化漂浮速度
            int randomSpeed = random.nextInt(3);
            switch (randomSpeed) {
                case 0:
                    starInfo.speed = mFloatTransLowSpeed;
                    break;
                case 1:
                    starInfo.speed = mFloatTransMidSpeed;
                    break;
                case 2:
                    starInfo.speed = mFloatTransFastSpeed;
                    break;
                default:
                    starInfo.speed = mFloatTransMidSpeed;
                    break;
            }

            // 初始化星球透明度
            starInfo.alpha = getStarSize(0.3f, 0.8f);
            // 初始化星球位置
            starInfo.xLocation = (int) (starLocation[0] * mTotalWidth);
            starInfo.yLocation = (int) (starLocation[1] * mTotalHeight);
            Logger.e("xLocation = " + starInfo.xLocation + "--yLocation = "
                    + starInfo.yLocation);
            Logger.e("stoneSize = " + starSize + "---stoneAlpha = "
                    + starInfo.alpha);
            // 初始化星球位置
            starInfo.direction = getStarDirection();
            mStarInfos.add(starInfo);
        }

    }

    private void drawStarDynamic(int count, StarInfo starInfo,
                                 Canvas canvas, Paint paint) {

        float starAlpha = starInfo.alpha;
        int xLocation = starInfo.xLocation;
        int yLocation = starInfo.yLocation;
        float sizePercent = starInfo.sizePercent;

        xLocation = (int) (xLocation / sizePercent);
        yLocation = (int) (yLocation / sizePercent);

        Bitmap bitmap = null;
        Rect srcRect = null;
        Rect destRect = new Rect();

        if (count % 3 == 0) {

//            bitmap = earth;
//            srcRect = mStarOneSrcRect;
//            destRect.set(xLocation, yLocation,
//                    xLocation + mStarOneWidth, yLocation
//                            + mStarOneHeight);
        } else if (count % 2 == 0) {
//            bitmap = jupiter;
//            srcRect = mStarThreeSrcRect;
//            destRect.set(xLocation, yLocation, xLocation
//                    + mStarThreeWidth, yLocation + mStarThreeHeight);
        } else {
//            bitmap = earth;
//            srcRect = mStarTwoSrcRect;
//            destRect.set(xLocation, yLocation, xLocation
//                    + mStarTwoWidth, yLocation + mStarTwoHeight);
        }

        paint.setAlpha((int) (starAlpha * 255));
        canvas.save();
        canvas.scale(sizePercent, sizePercent);
        canvas.drawBitmap(bitmap, srcRect, destRect, paint);
        canvas.restore();

    }
}
