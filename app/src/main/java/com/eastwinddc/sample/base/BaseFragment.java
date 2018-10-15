package com.eastwinddc.sample.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ewinddc on 2018/6/23
 */
public class BaseFragment extends Fragment {
    private boolean isViewCreated = false;
    private boolean isVisible =false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        isViewCreated = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if(!isViewCreated){
            return;
        }
        if(isVisibleToUser){
            onLazyResume();
        }else {
            onLazyPause();
        }
    }

    protected void onLazyResume(){

    }
    protected void onLazyPause(){

    }
    @Override
    public void onResume() {
        super.onResume();
        if(isVisible){
            onLazyResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        onLazyPause();
    }
}
