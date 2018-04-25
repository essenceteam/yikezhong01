package com.example.liufan.xiangmu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.DZFragAdapter;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufan on 2018/4/24.
 */

public class CrosstalkFragment extends Fragment implements DuanZiIView{

    private View view;
    private List<DZListBean.DataBean> list;
    private XRecyclerView mXrlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.crosstalk_dz, container, false);
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
    }

    @Override
    public void dzOnSuccess(DZListBean dzListBean) {
        list = new ArrayList<>();
        List<DZListBean.DataBean> data = dzListBean.getData();
        list.addAll(data);
        DZFragAdapter dzFragAdapter = new DZFragAdapter(list,getActivity());
        mXrlv.setAdapter(dzFragAdapter);
        mXrlv.setLoadingMoreEnabled(true);


    }

    @Override
    public void dzOnFail(String e) {

    }
}

