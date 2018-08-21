package com.example.pc_304.testviewpager.viewpager4;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by KangJH on 2018/8/20.
 * The harder you work, the luckier you will be.
 */
public class MyPageTransform implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        if (position < -1) { // [-Infinity,-1)
            view.setAlpha(0);
        } else if (position <= 1) { // [-1,1]//a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else { // (1,+Infinity]// This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
