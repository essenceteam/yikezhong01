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

/**
 * Created by liufan on 2018/4/24.
 */

public class VideoFragment extends Fragment {

    private TabLayout video_tab;
    private ViewPager video_vp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_frag_view, null);
        video_tab = view.findViewById(R.id.video_tab);
        video_vp = view.findViewById(R.id.video_vp);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
//        video_vp.setAdapter();

        return view;
    }
}
