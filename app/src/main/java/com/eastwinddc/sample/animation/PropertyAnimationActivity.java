package com.eastwinddc.sample.animation;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.eastwinddc.sample.base.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/23.
 */

public class PropertyAnimationActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String[] titleArray = new String[]{"KeyFrame","Layout"};
    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initViews() {
        super.initViews();
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new KeyFrameFragment();
                    case 1:
                        return new LayoutAnimationFragment();
                        default:
                            return new LayoutAnimationFragment();
                }

            }

            @Override
            public int getCount() {
                return titleArray.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleArray[position];
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }

}
