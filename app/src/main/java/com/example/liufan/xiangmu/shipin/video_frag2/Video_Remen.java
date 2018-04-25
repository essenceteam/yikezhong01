package com.example.liufan.xiangmu.shipin.video_frag2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Video_ReMen_Adapter;
import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.example.liufan.xiangmu.shipin.presenter.Video_Presenter;
import com.example.liufan.xiangmu.shipin.view.Video_OnView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class Video_Remen extends Fragment implements Video_OnView {

    private XRecyclerView video_remen_xrecy;
    private Video_ReMen_Adapter video_remen_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_remen_view, null);
        video_remen_xrecy = view.findViewById(R.id.video_remen_xrecy);
        video_remen_xrecy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=101&type=1&page=1
        Video_Presenter video_presenter = new Video_Presenter(this);
        video_presenter.getVideo_HQSP("android","10","1","1");

        return view;
    }

    @Override
    public void onError(String ss) {

    }

    @Override
    public void onSuccess(Object object) {
        //
        HQSPBean hqspBean = (HQSPBean) object;
        List<HQSPBean.DataBean> data = hqspBean.getData();
        //Log.i("LLLLLC",""+hqspBean.getData().get(0).getCreateTime());
        //适配器
        video_remen_adapter = new Video_ReMen_Adapter(getActivity(),data);
        video_remen_xrecy.setAdapter(video_remen_adapter);
    }
}
