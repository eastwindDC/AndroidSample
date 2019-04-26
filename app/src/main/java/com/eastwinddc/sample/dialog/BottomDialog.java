package com.eastwinddc.sample.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by baimei on 2019/4/25.
 */
public class BottomDialog extends Dialog {
    private static final String TAG = BottomDialog.class.getSimpleName();
    public BottomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = 500;
            params.gravity = Gravity.BOTTOM;
            window.setAttributes(params);
            window.setBackgroundDrawableResource(android.R.color.white);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
}
