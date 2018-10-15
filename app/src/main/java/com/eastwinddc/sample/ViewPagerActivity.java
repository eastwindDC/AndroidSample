package com.eastwinddc.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwinddc.sample.base.BaseActivity;
import com.eastwinddc.sample.base.BaseFragment;

import java.util.logging.Logger;

/**
 * Created by ewinddc on 2018/10/15
 */
public class ViewPagerActivity extends BaseActivity {
    private static final String TAG = ViewPagerActivity.class.getSimpleName();
    private ViewPager viewPager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void initViews() {
        super.initViews();
        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                Log.d(TAG, "getItem: "+position);
//                return new InnerFragment(position);
//            }
//
//            @Override
//            public int getCount() {
//                return 4;
//            }
//        });
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Log.d(TAG, "getItem: "+position);
                return new InnerFragment(position);
            }

            @Override
            public int getCount() {
                return 10;
            }
        });
    }

    @SuppressLint("ValidFragment")
    private static class InnerFragment extends BaseFragment {
        private int position;
        public InnerFragment(int position) {
            this.position = position;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            Log.d(TAG, "onCreateView: "+position);
            TextView textView= new TextView(getContext());
            textView.setText(String.valueOf(position));
            textView.setTextSize(200);
            return textView;
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d(TAG, "onResume: "+position);
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d(TAG, "onPause: "+position);
        }

        @Override
        protected void onLazyResume() {
            super.onLazyResume();
            Log.d(TAG, "onLazyResume: "+position);
        }

        @Override
        protected void onLazyPause() {
            super.onLazyPause();
            Log.d(TAG, "onLazyPause: "+position);
        }
    }
}
