package com.eastwinddc.sample.animation.transition;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseActivity;

/**
 * Created by ewinddc on 2018/6/25
 */
public class TransitionActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String[] titleArray = new String[]{"general","noScene","custom"};
    @Override
    protected int getLayoutId() {
        return R.layout.activity_tab_viewpager;
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
                        return new BasicTransitionFragment();
                    case 1:
                        return new NoSceneFragment();
                    case 2:
                        return new CustomTransitionFragment();
                        default:
                            return new BasicTransitionFragment();
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
