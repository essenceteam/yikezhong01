package com.example.liufan.xiangmu.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;
import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Tuijian_Guanzhu_baseadapter;
import com.example.liufan.xiangmu.adapter.Tuijian_Video_baseadapter;
import com.example.liufan.xiangmu.tuijain.View.IGuanzhuView;
import com.example.liufan.xiangmu.tuijain.View.IShiPinView;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianguanzhuBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.example.liufan.xiangmu.tuijain.presenter.Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2018/4/25.
 */

public class GuanZhu_Fragment extends Fragment {
    @BindView(R.id.remenrev1)
    XRecyclerView remenrev1;
    @BindView(R.id.sw)
    SwipyRefreshLayout sw;
    Unbinder unbinder;
    private View view;
    private int page = 1;
    com.example.liufan.xiangmu.tuijain.presenter.Presenter Presenter = new Presenter ();
    public List<TuijianguanzhuBean.DataBean> data;
    private Tuijian_Guanzhu_baseadapter tuijian_guanzhu_baseadapter;
    private boolean boo;
    private boolean bo;
    private int uid;
    private int userInt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.tuijian_guanzhu_layout, container, false);
        unbinder = ButterKnife.bind (this, view);
        SharedPreferences user = getActivity ().getSharedPreferences ("USER", Context.MODE_PRIVATE);
        userInt = user.getInt ("uid", this.uid);

        bo = user.getBoolean ("bo", boo);
        remenrev1.setLayoutManager (new LinearLayoutManager (getActivity ()));
        sw.setDirection (SwipyRefreshLayoutDirection.BOTH);
        sw.setColorSchemeResources (R.color.colorAccent,R.color.colorPrimaryDark,R.color.colorPrimary);
        sw.setOnRefreshListener (new SwipyRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh(int index) {
                page = 1;
                new Handler ().postDelayed (new Runnable () {
                    @Override
                    public void run() {
                        Log.i ("LLLLJIAZAI", "刷新");
                        getdata1 (page,userInt);
                        tuijian_guanzhu_baseadapter.notifyDataSetChanged ();
                        sw.setRefreshing (false);
                    }
                }, 3000);
            }

            @Override
            public void onLoad(int index) {
                page++;
                new Handler ().postDelayed (new Runnable () {
                    @Override
                    public void run() {
                        Log.i ("LLLLJIAZAI", "刷新");
                        Log.i ("LLLLJIAZAI", "加载");
                        data.clear ();
                        getdata1 (page,userInt);
                        tuijian_guanzhu_baseadapter.notifyDataSetChanged ();
                        sw.setRefreshing (false);
                    }
                }, 3000);
            }
        });
        getdata1 (page,userInt);
        return view;
    }

    //视频加载
    private void getdata1(int page,int userInt) {

            Presenter.getvrdiopresenter1 ("android", page, "1", userInt+"", new IGuanzhuView () {
                @Override
                public void TuijianShiPinOnSuccess(TuijianguanzhuBean TuijianguanzhuBean) {
                    data = TuijianguanzhuBean.getData ();
                    tuijian_guanzhu_baseadapter = new Tuijian_Guanzhu_baseadapter (getActivity (),data);
                    remenrev1.setAdapter (tuijian_guanzhu_baseadapter);
                }

                @Override
                public void TuijianShiPinOnError(Throwable Throwable) {
                    Log.i ("推荐guangzhi", Throwable.getMessage ());
                }
            });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }
}
