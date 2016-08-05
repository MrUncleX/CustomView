package com.ljx.demo.androidtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by LJX on 2016/8/3.
 */
public class CircleTextView extends View {

    private String StrText;
    private int StrSize;
    private int StrColor;
    private int CircleColor;

    private float zoom = 1f;;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CircleTextView(Context context) {
        this(context, null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCircleTextView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MyCircleTextView_strText:
                    StrText = a.getString(attr);
                    break;
                case R.styleable.MyCircleTextView_strColor:
                    // 默认颜色设置为黑色
                    StrColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.MyCircleTextView_circleColor:
                    // 默认颜色设置为黑色
                    CircleColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.MyCircleTextView_strSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    StrSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();

        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(StrSize);
        // mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(StrText, 0, StrText.length(), mBound);


//        this.setOnClickListener(new OnClickListener()
//        {
//
//            @Override
//            public void onClick(View v)
//            {
//                if(zoom == 1f) {
//                    zoom = 3f;
//
////                    setX(getRootView().getWidth()/2 - getMeasuredWidth()/2);
////                    setY(getRootView().getHeight()/2 - getMeasuredHeight()/2);
//                }else{
//                    zoom = 1f;
////                    setX(getRootView().getWidth()/2 - getMeasuredWidth()/2);
////                    setY(getRootView().getHeight()/2 - getMeasuredHeight()/2);
//                }
//                offsetLeftAndRight(50);
////                setScaleX(zoom);
////                setScaleY(zoom);
//
//                postInvalidate();
//            }
//
//        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(StrSize);
            mPaint.getTextBounds(StrText, 0, StrText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(StrSize);
            mPaint.getTextBounds(StrText, 0, StrText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }


        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(CircleColor);
//        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        canvas.drawCircle(getMeasuredWidth()/2, getMeasuredHeight()/2, Math.min(getMeasuredWidth()/2, getMeasuredHeight()/2), mPaint);

        mPaint.setColor(StrColor);
        canvas.drawText(StrText, (getWidth() / 2 - mBound.width() / 2), (getHeight() / 2 + mBound.height() / 2), mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.d("ljx","View onTouchEvent" + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.d("ljx","View dispatchTouchEvent"+super.dispatchTouchEvent(event));
        return super.dispatchTouchEvent(event);
    }
}
