package com.example.liufan.xiangmu.shipin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Video_ReMen_Adapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class Video_Remen extends Fragment {

    private XRecyclerView video_remen_xrecy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_remen_view, null);
        video_remen_xrecy = view.findViewById(R.id.video_remen_xrecy);
        Video_ReMen_Adapter video_remen_adapter = new Video_ReMen_Adapter();
        video_remen_xrecy.setAdapter(video_remen_adapter);
        return view;
    }
}
