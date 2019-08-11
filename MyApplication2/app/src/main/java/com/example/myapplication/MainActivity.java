package com.example.myapplication;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private LinearLayout mIndicatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mIndicatorLayout = (LinearLayout) findViewById(R.id.indicatorLayout);
        List<View> imageViews = new ArrayList<>();
        for(int i = 0;i<6;i++){

            TextView iv = new TextView(this);
            iv.setText("这是文本" + i);
            imageViews.add(iv);
        }


        mViewPager.setAdapter(new MyPagerAdapter(imageViews));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(getApplication(),"这是页面" + i,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mViewPager.addOnPageChangeListener(new PageIndicator(this, mIndicatorLayout, imageViews.size()));

    }

    public class MyPagerAdapter extends PagerAdapter {
        private List<View> views;

        public MyPagerAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // return super.instantiateItem(container, position);
            View view=views.get(position);
            container.addView(view);
            return  view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return super.getPageTitle(position);
            return "标题"+position;
        }
    }
}
