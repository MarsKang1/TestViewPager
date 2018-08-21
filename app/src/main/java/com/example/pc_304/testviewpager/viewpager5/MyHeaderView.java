package com.example.pc_304.testviewpager.viewpager5;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.pc_304.testviewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KangJH on 2018/8/17.
 * The harder you work, the luckier you will be.
 */

public class MyHeaderView extends RelativeLayout {
    private MyViewPager vp_header;
    private List<View> headerViews;

    public MyHeaderView(Context context) {
        this(context, null);
    }

    public MyHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.header_view, this);
        vp_header = findViewById(R.id.vp_header);
        headerViews = new ArrayList<>();

    }

    public void initView() {
        int drawables[] = {R.drawable.d_01, R.drawable.d_02, R.drawable.d_03, R.drawable.d_04, R.drawable.d_05};
        for (int i = 0; i < 5; i++) {
            RelativeLayout rlHeaderItem = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.header_pager_view, null);
            ImageView ivItem = rlHeaderItem.findViewById(R.id.iv_header_item);
            ivItem.setBackgroundDrawable(getContext().getResources().getDrawable(drawables[i]));
            headerViews.add(rlHeaderItem);
        }
        HeaderPagerAdapter adapter = new HeaderPagerAdapter(headerViews);
        vp_header.setAdapter(adapter);
        vp_header.setCurrentItem(headerViews.size() * 500);
        vp_header.startScroll();
        vp_header.addOnPageChangeListener(new MyPagerChangedListener());
    }


    class MyPagerChangedListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
