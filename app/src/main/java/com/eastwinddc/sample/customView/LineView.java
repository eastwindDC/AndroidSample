package com.eastwinddc.sample.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ewinddc on 2018/8/2
 */
public class LineView extends BaseView {
    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStrokeWidth(200);
    }
    private int x;
    private int y;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y=0;
        x=0;
        canvas.drawLine(x,y,x,y+100,paint);
        x=getWidth()/2;
        canvas.drawLine(x,y,x,y+100,paint);
        x=getWidth();
        canvas.drawLine(x,y,x,y+100,paint);

    }
}
