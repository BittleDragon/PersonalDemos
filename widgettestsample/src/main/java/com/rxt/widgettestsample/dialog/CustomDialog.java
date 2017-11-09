package com.rxt.widgettestsample.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * 自定义对话框
 * Created by raoxuting on 2017/9/27.
 */

public class CustomDialog extends Dialog {

    public CustomDialog(@NonNull Context context) {
        this(context, 0);
    }

    public CustomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        resizeDialog();
    }

    @Override
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        resizeDialog();
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        resizeDialog();
    }

    private void resizeDialog() {
        //如果需要全屏，设置背景
//        getWindow().setBackgroundDrawable(new BitmapDrawable());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(attributes);
    }

    /**
     * 设置对话框位置、大小
     * @param x 0为中间
     * @param y 0为中间
     * @param width 对话框宽度
     * @param height 对话框高度
     */
    public void setDialogPostionAndSize(int x, int y, int width, int height) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = width;
        attributes.height = height;
        attributes.x = x;
        attributes.y = y;
        getWindow().setAttributes(attributes);

    }

    //    public static class Builder {
//
//        private Context context;
//
//        public Builder(Context context) {
//            this.context = context;
//        }
//
//        public CustomDialog hellotest() {
//            return new CustomDialog(context);
//        }
//    }
}
