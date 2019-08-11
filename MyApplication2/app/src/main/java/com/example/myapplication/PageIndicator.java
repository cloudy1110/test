package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class PageIndicator implements ViewPager.OnPageChangeListener {
    private int mPageCount;//页数
    private List<View> mImgList;//保存img总个数

    public PageIndicator(Context context, LinearLayout linearLayout, int pageCount) {
        this.mPageCount = pageCount;

        mImgList = new ArrayList<>();
        final int imgSize = 25;

        for (int i = 0; i < mPageCount; i++) {
            View imageView = new View(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //为小圆点左右添加间距
            params.leftMargin = 10;
            params.rightMargin = 10;
            //给小圆点一个默认大小
            params.height = 4;
            params.width = 80;
            if (i == 0) {
                imageView.setBackgroundColor(Color.RED);
            } else {
                imageView.setBackgroundColor(Color.GRAY);
            }
            //为LinearLayout添加ImageView
            linearLayout.addView(imageView, params);
            mImgList.add(imageView);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mPageCount; i++) {
            //选中的页面改变小圆点为选中状态，反之为未选中
            if ((position % mPageCount) == i) {
                (mImgList.get(i)).setBackgroundColor(Color.RED);
            } else {
                (mImgList.get(i)).setBackgroundColor(Color.GRAY);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}