package com.example.liufan.xiangmu.tuijain.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.TuiJian_ReMen_Baseadapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2018/4/25.
 */

public class Remen_Fragment extends Fragment {
    @BindView(R.id.remenrev1)
    XRecyclerView remenrev1;
    Unbinder unbinder;
    private View view;
    private View inflate;
    private Banner bann;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.tuijian_remen_layout, container, false);
        unbinder = ButterKnife.bind (this, view);
        remenrev1.addHeaderView (inflate );
        bann = inflate.findViewById (R.id.bann);
        remenrev1.setLayoutManager (new LinearLayoutManager (getActivity ()));
        remenrev1.setLoadingListener (new XRecyclerView.LoadingListener () {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
//        TuiJian_ReMen_Baseadapter TuiJian_ReMen_Baseadapter=new TuiJian_ReMen_Baseadapter ();
//        remenrev1.setAdapter (TuiJian_ReMen_Baseadapter);
        getlunbo();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }
    //轮播图
    public void getlunbo(){


    }
}
