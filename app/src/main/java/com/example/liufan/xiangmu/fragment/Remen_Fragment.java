package com.example.liufan.xiangmu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Tuijian_Video_baseadapter;
import com.example.liufan.xiangmu.tuijain.View.IShiPinView;
import com.example.liufan.xiangmu.tuijain.View.ItuijianView;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.example.liufan.xiangmu.tuijain.presenter.Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.bann)
    Banner bann;
    private View view;
    private int page =1;
    Presenter Presenter = new Presenter ();
    List<String> list_tu = new ArrayList<> ();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.tuijian_remen_layout, container, false);
        unbinder = ButterKnife.bind (this, view);
        remenrev1.setLayoutManager (new LinearLayoutManager (getActivity ()));
        remenrev1.setLoadingListener (new XRecyclerView.LoadingListener () {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
        getlunbo ();
        getdata1 ();
        return view;
    }

    //上啦刷新，下拉加载
    private void getdata1() {
       Presenter.getvrdiopresenter ("android", page, new IShiPinView () {

           private List<TuijianshipinBean.DataBean> data;

           @Override
           public void TuijianShiPinOnSuccess(TuijianshipinBean TuijianshipinBean) {
               data = TuijianshipinBean.getData ();
               Tuijian_Video_baseadapter Tuijian_Video_baseadapter=new Tuijian_Video_baseadapter (getActivity (),data);
               remenrev1.setAdapter (Tuijian_Video_baseadapter);



           }

           @Override
           public void TuijianShiPinOnError(Throwable Throwable) {

           }
       });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }

    //轮播图
    public void getlunbo() {

        Presenter.getlunbopresenter (new ItuijianView () {
            private List<LunBoBean.DataBean> data;

            @Override
            public void TuijianOnSuccess(LunBoBean LunBoBean) {
                data = LunBoBean.getData ();
                for (int i = 0; i < data.size (); i++) {
                    String icon = data.get (i).getIcon ();
                    list_tu.add (icon);
                }
                bann.setImages (list_tu);
                bann.setDelayTime (1000);
                bann.setImageLoader (new ImageLoader () {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Picasso.with (context).load ((String) path).into (imageView);
                    }
                });
                bann.start ();
            }

            @Override
            public void TuijianOnError(Throwable Throwable) {

            }
        });
    }
}
