package com.eastwinddc.sample.animation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/23
 */
public class LayoutAnimationFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout root ;
    private int cur = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        root = (LinearLayout) inflater.inflate(R.layout.fragment_layout_animation,container
                ,false);
        root.setOnClickListener(this);
        return root;
    }


    @Override
    public void onClick(View v) {
        Button textView = new Button(getContext());
        textView.setText(String.valueOf(cur++));
        root.addView(textView,1);
    }
}
