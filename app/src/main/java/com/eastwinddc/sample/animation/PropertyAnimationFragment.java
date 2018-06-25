package com.eastwinddc.sample.animation;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/25
 */
public class PropertyAnimationFragment extends BaseFragment implements View.OnClickListener{
    private View target;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_property_animation,container,false);
        target = root.findViewById(R.id.text);
        root.findViewById(R.id.keyframe).setOnClickListener(this);
        root.findViewById(R.id.view_property).setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.keyframe:
                startKeyframe();
                break;
            case R.id.view_property:
                startViewProperty();
                break;
        }
    }

    private void startViewProperty(){
        target.animate().x(1000).setDuration(3000);
    }
    private void startKeyframe(){
        Keyframe kf1 = Keyframe.ofFloat(0f,0);
        Keyframe kf2 = Keyframe.ofFloat(0.5f,1000);
        kf2.setInterpolator(new AccelerateDecelerateInterpolator());
        Keyframe kf3 = Keyframe.ofFloat(1f,500);
        kf3.setInterpolator(new AccelerateDecelerateInterpolator());
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
                "x",kf1,kf2,kf3);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(target,propertyValuesHolder);
        rotationAnim.setDuration(5000);
        rotationAnim.start();
    }
}
