package com.eastwinddc.sample.animation.transition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/25
 */
public class NoSceneFragment extends BaseFragment implements View.OnClickListener{
    private ViewGroup root;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        root = (ViewGroup) inflater.inflate(R.layout.scene_b,container,false);
        root.setOnClickListener(this);
        textView1 = root.findViewById(R.id.text1);
        textView2 = root.findViewById(R.id.text2);
        textView3 = root.findViewById(R.id.text3);

        return root;
    }

    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(root);
        root.removeView(textView1);
    }
}
