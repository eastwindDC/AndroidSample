package com.eastwinddc.sample.customView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by ewinddc on 2017/11/24.
 */

public class HydrogenView extends BaseView implements View.OnTouchListener{
    private static final String TAG = HydrogenView.class.getSimpleName();
    ObjectAnimator objectAnimator;
    private int degree = 0;
    private int cx =400;
    private int cy= 300;
    private int centerRadius = 20;
    private int pointRadius = 10;
    private int annulusRadius = 200;

    public HydrogenView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, annulusRadius, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, centerRadius, paint);

        canvas.drawCircle(getPX(annulusRadius),getPY(annulusRadius),pointRadius,paint);
//        canvas.drawCircle(cx+annulusRadius,cy,pointRadius,paint);
    }

    private float getPX(int radius){
        return (float) (Math.cos(degree * Math.PI/180)*radius) + cx;
    }
    private float getPY(int radius){
        return (float) (Math.sin(degree * Math.PI/180)*radius) + cy;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }
    public void start(){
        if(objectAnimator == null){
            objectAnimator  = ObjectAnimator.ofInt(this,"degree",360);
            objectAnimator.setDuration(4000);
            objectAnimator.setRepeatMode(ValueAnimator.RESTART);
            objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
            objectAnimator.setInterpolator(new LinearInterpolator());
            objectAnimator.start();
        }
        objectAnimator.resume();
    }
    public void stop(){
        if(objectAnimator != null){
            objectAnimator.pause();
        }
    }
    float lastX = 0;
    float lastY = 0;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        float curX = 0;
        float curY = 0;

        switch (action){
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                curX = event.getX();
                curY = event.getY();

                cx += (curX - lastX);
                cy += (curY - lastY);

                lastX = curX;
                lastY = curY;

                invalidate();
                break;
            default:
                return false;

        }
        return true;
    }
}
