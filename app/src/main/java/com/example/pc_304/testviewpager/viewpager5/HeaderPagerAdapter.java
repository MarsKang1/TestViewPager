package com.example.pc_304.testviewpager.viewpager5;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HeaderPagerAdapter extends PagerAdapter {
    private List<View> headerViews;

    public HeaderPagerAdapter(List<View> headerViews) {
        this.headerViews = headerViews;
    }

    public void setDataSet(List<View> posterViews) {
        headerViews = posterViews;
    }

    @Override
    public int getCount() {
        if (headerViews == null || headerViews.size() == 0) {
            return 0;
        }
        if (headerViews.size() == 1) {
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = headerViews.get(position % headerViews.size());
        if (view.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
        }
        container.addView(view);
        return headerViews.get(position % headerViews.size());
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
}
