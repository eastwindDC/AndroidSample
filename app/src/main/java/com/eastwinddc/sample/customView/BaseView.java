package com.eastwinddc.sample.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ewinddc on 2017/10/17.
 */

public class BaseView extends View{
    protected Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
