package com.eastwinddc.sample.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.eastwinddc.sample.R;

/**
 * Created by baimei on 2019/3/30.
 */
public class CameraMaskView extends View {
    private static final float ratio = 0.63f;
    private Context context;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rect = new RectF();
    private int strokWidth = 1;
    private float corner ;
    private int textStart ;
    private String text = "你好，这是我的测试相机";
    private int textSize;
    public CameraMaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        strokWidth = getResources().getDimensionPixelSize(R.dimen.camera_window_stroke_width);
        corner = getResources().getDimension(R.dimen.camera_window_corner);
        textSize = getResources().getDimensionPixelSize(R.dimen.camera_window_text_size);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        textStart = w/2;

        int padding = getResources().getDimensionPixelSize(R.dimen.camera_window_padding);
        int margin = getResources().getDimensionPixelSize(R.dimen.camera_window_margin_top);

        int width = w - 2 * padding;
        int height = (int) (width * ratio);

        int left = padding;
        int right =  left + width;
        int top = margin;
        int bottom = margin + height;
        rect.set(left,top,right,bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(getResources().getColor(R.color.camera_mask_bg));

        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(textSize);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawText(text,textStart,rect.bottom+textSize*3,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokWidth);
        canvas.drawRoundRect(rect,corner,corner,paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawRoundRect(rect,corner,corner,paint);


    }

}
