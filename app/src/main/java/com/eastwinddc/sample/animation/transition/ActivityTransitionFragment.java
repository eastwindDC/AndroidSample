package com.eastwinddc.sample.animation.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastwinddc.sample.CardViewActivity;
import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseActivity;
import com.eastwinddc.sample.base.BaseFragment;

/**
 * Created by ewinddc on 2018/6/26
 */
public class ActivityTransitionFragment extends BaseFragment implements View.OnClickListener{
    private View sharedView;
    private View m1View;
    private View m2View;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_activity_transition,container,false);
        root.findViewById(R.id.startTransition).setOnClickListener(this);
        root.findViewById(R.id.startShared).setOnClickListener(this);
        root.findViewById(R.id.startMultiple).setOnClickListener(this);
        sharedView = root.findViewById(R.id.startShared);
        m1View = root.findViewById(R.id.startMultiple);
        m2View = root.findViewById(R.id.startMultiple1);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startTransition:
                startTransition();
                break;
            case R.id.startShared:
                startShared();
                break;
            case R.id.startMultiple:
                startMultiple();
                break;
        }
    }

    private void startTransition(){
        Intent intent = new Intent(getContext(), CardViewActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle());
    }
    private void startShared(){
        Intent intent = new Intent(getContext(), TargetTransitionActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),sharedView,"shared").toBundle());
    }
    private void startMultiple(){
        Intent intent = new Intent(getContext(), TargetTransitionActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                Pair.create(m1View,"mshared1"),
                Pair.create(m2View,"mshared2")).toBundle());

    }
}
