package com.example.liufan.xiangmu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.DZFragAdapter;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.presenter.IPresenter;
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufan on 2018/4/24.
 */

public class CrosstalkFragment extends Fragment implements DuanZiIView{

    private int page=1;
    private View view;
    private List<DZListBean.DataBean> list = new ArrayList<>();
    private XRecyclerView mXrlv;
    private IPresenter iPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.crosstalk_dz, container, false);
        iPresenter = new IPresenter(this);
             iPresenter.getDZdata(API.Url,page);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取控件
        mXrlv = view.findViewById(R.id.xrlv);
        //设置线性垂直布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mXrlv.setLayoutManager(layoutManager);

        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                iPresenter.getDZdata(API.Url,page);
                mXrlv.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                page++;
                iPresenter.getDZdata(API.Url,page);
                mXrlv.loadMoreComplete();
            }
        });

    }

    @Override
    public void dzOnSuccess(DZListBean dzListBean) {
        String code = dzListBean.getCode();
        Log.d("CrosstalkFragment", code);
        list = new ArrayList<>();
        list = new ArrayList<>();

        List<DZListBean.DataBean> data = dzListBean.getData();
        DZFragAdapter dzFragAdapter = new DZFragAdapter(data,getActivity());
        mXrlv.setAdapter(dzFragAdapter);
        mXrlv.setLoadingMoreEnabled(true);


    }

    @Override
    public void dzOnFail(String e) {
        Log.d("CrosstalkFragment", e.toString());
    }
}

