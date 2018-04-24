package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context context;
    List<String> list;
    FragmentManager fm;
    List<Fragment> listFrag;
    public ViewPagerAdapter(Context context, List<String> list, FragmentManager fm1,List<Fragment> listFrag){
        super(fm1);
        this.context = context;
        this.list = list;
        this.fm = fm1;
        this.listFrag = listFrag;
    }

    @Override
    public Fragment getItem(int position) {
        return listFrag.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return listFrag.size();
    }
}
