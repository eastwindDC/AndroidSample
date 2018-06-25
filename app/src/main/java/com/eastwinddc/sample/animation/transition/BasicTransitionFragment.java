package com.eastwinddc.sample.animation.transition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/25
 */
public class BasicTransitionFragment extends BaseFragment implements View.OnClickListener{
    private Scene aScene;
    private Scene bScene;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_basic_transition,container,false);
        root.findViewById(R.id.start).setOnClickListener(this);
        root.findViewById(R.id.reverse).setOnClickListener(this);
        ViewGroup sceneRoot = root.findViewById(R.id.scene_root);
        aScene = Scene.getSceneForLayout(sceneRoot,R.layout.scene_a,getContext());
        bScene = Scene.getSceneForLayout(sceneRoot,R.layout.scene_b,getContext());
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                TransitionManager.go(bScene);
                break;
            case R.id.reverse:
                TransitionManager.go(aScene,new ChangeBounds());
                break;
        }

    }
}
