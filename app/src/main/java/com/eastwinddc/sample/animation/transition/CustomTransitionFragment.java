package com.eastwinddc.sample.animation.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/26
 */
public class CustomTransitionFragment extends BaseFragment implements View.OnClickListener{
    private ViewGroup root;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private MyTransition transition = new MyTransition();
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

        TransitionManager.beginDelayedTransition(root,transition);
        root.removeView(textView1);
    }


    private static class MyTransition extends Transition{

        private static final String X_PROP = "CustomTransition:x";
        @Override
        public void captureStartValues(TransitionValues transitionValues) {
            captureValues(transitionValues);
        }

        @Override
        public void captureEndValues(TransitionValues transitionValues) {
            captureValues(transitionValues);
        }

        @Override
        public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
            //we dont animate the views which are added or removed
            if(endValues == null || startValues == null){
                return null;
            }
            //we dont animate if the view's property is not change
            if(startValues == endValues){
                return null;
            }
            float startX = (float) startValues.values.get(X_PROP);
            float endX = (float) endValues.values.get(X_PROP);
            ObjectAnimator xanimator = ObjectAnimator.ofFloat(endValues.view,View.X,startX,endX);
            return xanimator;
        }

        private void captureValues(TransitionValues transitionValues){
            View view = transitionValues.view;
            transitionValues.values.put(X_PROP,view.getX());
        }
    }
}
