package com.eastwinddc.sample.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ewinddc on 2017/10/17.
 */

public class TriangleView extends BaseView{
    Path trianglepath = new Path();
    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        trianglepath.moveTo(500,0);
        trianglepath.lineTo(700,200);
        trianglepath.lineTo(300,200);
        trianglepath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(trianglepath,paint);
    }
}
