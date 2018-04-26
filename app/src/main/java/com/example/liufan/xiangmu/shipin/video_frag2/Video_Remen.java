package com.example.liufan.xiangmu.shipin.video_frag2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.activity.Video_ShiPinActivity;
import com.example.liufan.xiangmu.adapter.Video_ReMen_Adapter;
import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.example.liufan.xiangmu.shipin.presenter.Video_Presenter;
import com.example.liufan.xiangmu.shipin.view.Video_OnView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class Video_Remen extends Fragment implements Video_OnView {

    private XRecyclerView video_remen_xrecy;
    private Video_ReMen_Adapter video_remen_adapter;
    private Video_Presenter video_presenter;
    List<HQSPBean.DataBean> data1 = new ArrayList<>();
    int pager = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_remen_view, null);
        video_remen_xrecy = view.findViewById(R.id.video_remen_xrecy);
        video_remen_xrecy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //允许刷新，加载更多
        video_remen_xrecy.setPullRefreshEnabled(true);
        video_remen_xrecy.setLoadingMoreEnabled(true);
        //https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=101&type=1&page=1
        video_presenter = new Video_Presenter(this);
        video_presenter.getVideo_HQSP("android","101","1",pager+"");

        video_remen_xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //清空数据‘
                data1.clear();
                pager = 1;
                //刷新
                video_presenter = new Video_Presenter(Video_Remen.this);
                video_presenter.getVideo_HQSP("android","101","1",pager+"");
                video_remen_adapter.notifyDataSetChanged();
                //刷新完成
                video_remen_xrecy.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                pager++;
                //加载
                video_presenter = new Video_Presenter(Video_Remen.this);
                video_presenter.getVideo_HQSP("android","101","1",pager+"");
                video_remen_adapter.notifyDataSetChanged();
                //刷新完成
                video_remen_xrecy.loadMoreComplete();
            }
        });
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
        data1.addAll(data);
        //适配器
        video_remen_adapter = new Video_ReMen_Adapter(getActivity(),data1);
        video_remen_xrecy.setAdapter(video_remen_adapter);

        video_remen_adapter.onItemClick(new Video_ReMen_Adapter.Itemclick() {
            @Override
            public void itemclick(View view, int position) {
                String videoUrl = data1.get(position).getVideoUrl();
                Log.i("LLLLVideoURL",""+videoUrl);
                Intent intent = new Intent(getActivity(), Video_ShiPinActivity.class);
                intent.putExtra("videourl",""+videoUrl);
                startActivity(intent);
            }
        });

    }
}
