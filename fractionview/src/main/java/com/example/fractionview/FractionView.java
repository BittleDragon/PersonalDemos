package com.example.fractionview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * 分数自定义控件
 * Created by raoxuting on 2017/7/23.
 */

public class FractionView extends View {

    public static final String TAG = "分数控件";
    public static final String TAG2 = "文字宽高";
    public static final int DEFAULT_TEXTSIZE = 14;

    private int textSize = sp2px(DEFAULT_TEXTSIZE);

    private Paint paint;

    private String numerator = "2";
    private String denominator = "39";
    private float contentWidth;
    private float contentHeight;

    private int midspace = dp2px(1);

    public FractionView(Context context) {
        this(context, null);
    }

    public FractionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FractionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        //反锯齿
        paint.setAntiAlias(true);
        //字体大小
        paint.setTextSize(textSize);
        //实心
        paint.setStyle(Paint.Style.FILL);

        //测量文字宽度
        float numeratorWidth = paint.measureText(numerator);
        float denominatorWidth = paint.measureText(denominator);

        contentWidth = Math.max(numeratorWidth, denominatorWidth) + dp2px(4);
        contentHeight = (-paint.ascent() + paint.descent()) * 2;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY) {
            //宽度为wrap_content
            width = (int) contentWidth;
        }
        if (MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY) {
            //高度为wrap_content
            height = (int) contentHeight;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(getResources().getColor(R.color.blue));

        float numeratorBaseline = ((getHeight() - contentHeight)) / 2 + -paint.ascent();
        float denominatorBaseline =
                getHeight() - ((getHeight() - contentHeight)) / 2 - paint.descent();

        canvas.drawText(numerator, getWidth() / 2, numeratorBaseline, paint);

//        Log.e(TAG, "onDraw: textSize: " + textSize + ", rect.height: " + numeratroHeight
//                + ", paint.measure: " + -(paint.descent() + paint.ascent()));

        paint.setStrokeWidth(dp2px(1));
        canvas.drawLine((getWidth() - contentWidth) / 2, getHeight() / 2,
                (getWidth() - contentWidth) / 2 + contentWidth, getHeight() / 2, paint);

        canvas.drawText(denominator, getWidth() / 2, denominatorBaseline, paint);
    }

    /**
     * sp转px
     * @param value
     * @return
     */
    private int sp2px(int value) {
        return (int) TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_SP, value, getResources().getDisplayMetrics());
    }

    /**
     * dp转px
     * @param value
     * @return
     */
    private int dp2px(int value) {
        return (int) TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

}
