package com.example.pc_304.testviewpager.viewpager2;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by KangJH on 2018/8/20.
 * The harder you work, the luckier you will be.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> pagerViews;

    public MyPagerAdapter(List<View> pagerViews) {
        this.pagerViews = pagerViews;
    }

    @Override
    public int getCount() {
        if (pagerViews == null || pagerViews.size() == 0) {
            return 0;
        }
        if (pagerViews.size() == 1) {
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = pagerViews.get(position % pagerViews.size());
        if (view.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
        }
        container.addView(view);
        return pagerViews.get(position % pagerViews.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}