package com.example.liufan.xiangmu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.ViewPagerAdapter;
import com.example.liufan.xiangmu.shipin.view.Video_Fujin;
import com.example.liufan.xiangmu.shipin.view.Video_Remen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufan on 2018/4/24.
 */

public class VideoFragment extends Fragment {

    private TabLayout video_tab;
    private ViewPager video_vp;
    List<String> list = new ArrayList<>();
    List<Fragment> listFrag = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_frag_view, null);
        video_tab = view.findViewById(R.id.video_tab);
        video_vp = view.findViewById(R.id.video_vp);
        //tab字
        list.add("热门");
        list.add("附近");
        //fragment
        Video_Fujin video_fujin = new Video_Fujin();
        Video_Remen video_remen = new Video_Remen();
        //添加fragment
        listFrag.add(video_remen);
        listFrag.add(video_fujin);
        //添加viewpagr适配器
        viewPagerAdapter = new ViewPagerAdapter(getActivity(), list, getActivity().getSupportFragmentManager(), listFrag);
        video_vp.setAdapter(viewPagerAdapter);
        // tablayout.addTab可以将标题添加进Tab里面，true表示默认选中
        video_tab.addTab(video_tab.newTab().setText(list.get(0)), true);
        video_tab.addTab(video_tab.newTab().setText(list.get(1)), false);
        //这两个方法是将Tablayout和Viewpager联合起来
        video_tab.setupWithViewPager(video_vp);
        video_tab.setTabsFromPagerAdapter(viewPagerAdapter);
        return view;
    }
}
