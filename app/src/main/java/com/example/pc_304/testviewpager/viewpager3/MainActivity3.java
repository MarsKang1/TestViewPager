package com.example.pc_304.testviewpager.viewpager3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.pc_304.testviewpager.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private MyViewPager vp_mian1;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vp_mian1 = findViewById(R.id.vp_mian1);
        List<View> itemViews = installItems();
        adapter = new MyPagerAdapter(itemViews);
        vp_mian1.setAdapter(adapter);
        vp_mian1.setCurrentItem(itemViews.size() * 500);
        vp_mian1.startScroll();
    }

    public List<View> installItems() {
        List<View> views = new ArrayList<>();
        int drawables[] = {R.drawable.d_01, R.drawable.d_02, R.drawable.d_03, R.drawable.d_04, R.drawable.d_05};
        for (int i = 0; i < 5; i++) {
            RelativeLayout rlHeaderItem = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.header_pager_view, null);
            ImageView ivItem = rlHeaderItem.findViewById(R.id.iv_header_item);
            ivItem.setBackgroundDrawable(getResources().getDrawable(drawables[i]));
            views.add(rlHeaderItem);
        }
        return views;
    }

    @Override
    protected void onDestroy() {
        vp_mian1.stopScroll();
        super.onDestroy();
    }
}
