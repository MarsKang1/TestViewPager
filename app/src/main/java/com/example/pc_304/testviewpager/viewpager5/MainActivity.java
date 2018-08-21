package com.example.pc_304.testviewpager.viewpager5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pc_304.testviewpager.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_main;
    private MyHeaderView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("dada" + i);
        }
        lv_main = findViewById(R.id.lv_main);
        headerView=new MyHeaderView(this);
        lv_main.addHeaderView(headerView);
        lv_main.setAdapter(new MyAdapter(datas));
        headerView.initView();
    }

    private class MyAdapter extends BaseAdapter {
        private List<String> datas;
        private LayoutInflater inflater;

        public MyAdapter(List<String> datas) {
            this.datas = datas;
            inflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_main, null);
            ImageView ivItem = convertView.findViewById(R.id.iv_item);
            ivItem.setImageDrawable(getResources().getDrawable(R.drawable.d_0));
            return convertView;
        }
    }
}
