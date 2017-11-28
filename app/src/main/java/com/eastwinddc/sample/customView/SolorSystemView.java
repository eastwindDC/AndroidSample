package com.eastwinddc.sample.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by ewinddc on 2017/11/28.
 */

public class SolorSystemView extends BaseView{
    private static final int EARTH_RADIUS = 5;
    private static final int SOLOR_RADIUS = 50;
    private int cx;
    private int cy;
    private int annulusRadius = 600;
    public SolorSystemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, annulusRadius, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, SOLOR_RADIUS, paint);

        canvas.drawCircle(cx + annulusRadius,cy,EARTH_RADIUS,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        cx = getWidth()/2;
        cy = getHeight()/2;
    }
}
