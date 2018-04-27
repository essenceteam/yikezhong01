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
import com.example.liufan.xiangmu.adapter.Video_FuJin_Adapter;
import com.example.liufan.xiangmu.shipin.bean.Video_FuJinBean;
import com.example.liufan.xiangmu.shipin.presenter.Video_Presenter;
import com.example.liufan.xiangmu.shipin.view.Video_OnView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class Video_Fujin extends Fragment implements Video_OnView {

    private XRecyclerView video_fujin_xrecy;
    private Video_Presenter video_presenter;
    private Video_FuJin_Adapter video_remen_adapter;
    List<Video_FuJinBean.DataBean>  data1 = new ArrayList<>();
    int pager = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_fujin_view, null);
        video_fujin_xrecy = view.findViewById(R.id.video_fujin_xrecy);
        video_fujin_xrecy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //允许刷新，加载更多
        video_fujin_xrecy.setPullRefreshEnabled(true);
        video_fujin_xrecy.setLoadingMoreEnabled(true);
        //https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=101&type=1&page=1
        video_presenter = new Video_Presenter(this);
        //video_presenter.getVideo_HQSP("android","101","11080","1",pager+"");
        //video_presenter.getVideo_ReMen("F59DAFABFD3392862082B61174D823A6","android","101",""+pager);
        video_presenter.getVideo_FuJin("F59DAFABFD3392862082B61174D823A6","android","101","40.04710","116.3064",""+pager);
        video_fujin_xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //清空数据
                data1.clear();
                pager = 1;
                Log.i("LLLLJIAZAI","刷新");
                //刷新
                video_presenter = new Video_Presenter(Video_Fujin.this);
                video_presenter.getVideo_HQSP("android","101","11080","1",pager+"");
                video_remen_adapter.notifyDataSetChanged();
                //刷新完成
                video_fujin_xrecy.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                pager++;
                Log.i("LLLLJIAZAI","加载");
                //加载
                video_presenter = new Video_Presenter(Video_Fujin.this);
                video_presenter.getVideo_HQSP("android","101","11080","1",pager+"");
                video_remen_adapter.notifyDataSetChanged();
                //加载完成
                video_fujin_xrecy.loadMoreComplete();
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
        Video_FuJinBean video_fuJinBean = (Video_FuJinBean) object;
        List<Video_FuJinBean.DataBean> data = video_fuJinBean.getData();
        data1.addAll(data);
        //适配器
        video_remen_adapter = new Video_FuJin_Adapter(getActivity(),data1);
        video_fujin_xrecy.setAdapter(video_remen_adapter);
        //设置item之间的间隔
//        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
//        video_remen_xrecy.addItemDecoration(decoration);

        video_remen_adapter.onItemClick(new Video_FuJin_Adapter.Itemclick() {
            @Override
            public void itemclick(View view, int position) {
                String videoUrl = data1.get(position).getVideoUrl();
                String icon = data1.get(position).getUser().getIcon();
                String nickname = data1.get(position).getUser().getNickname();
                Log.i("LLLLVideoURL",""+videoUrl);
                Intent intent = new Intent(getActivity(), Video_ShiPinActivity.class);
                intent.putExtra("videourl",""+videoUrl);
                intent.putExtra("icon",""+icon);
                intent.putExtra("nickname",""+nickname);
                startActivity(intent);
            }
        });

    }
}
