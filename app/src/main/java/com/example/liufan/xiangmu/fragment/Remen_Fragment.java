package com.example.liufan.xiangmu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;
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
    @BindView(R.id.sw)
    SwipyRefreshLayout sw;
    private View view;
    private int page = 1;
    Presenter Presenter = new Presenter ();
    List<String> list_tu = new ArrayList<> ();
    private List<TuijianshipinBean.DataBean> data;
    private Tuijian_Video_baseadapter tuijian_video_baseadapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.tuijian_remen_layout, container, false);
        unbinder = ButterKnife.bind (this, view);

        remenrev1.setLayoutManager (new LinearLayoutManager (getActivity ()));
       sw.setDirection (SwipyRefreshLayoutDirection.BOTH);
       sw.setColorSchemeResources (R.color.colorAccent,R.color.colorPrimaryDark,R.color.colorPrimary);
       sw.setOnRefreshListener (new SwipyRefreshLayout.OnRefreshListener () {
           @Override
           public void onRefresh(int index) {
               new Handler ().postDelayed (new Runnable () {
                   @Override
                   public void run() {
                       Log.i ("LLLLJIAZAI", "刷新");
                       page = 1;
                       getdata1 (page);
                       tuijian_video_baseadapter.notifyDataSetChanged ();
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
                       getdata1 (page);
                       tuijian_video_baseadapter.notifyDataSetChanged ();
                       sw.setRefreshing (false);
                   }
               }, 3000);
           }
       });
        getlunbo ();
        getdata1 (page);
        return view;
    }

    //视频加载
    private void getdata1(int page) {
        Presenter.getvrdiopresenter ("android", page, "1", new IShiPinView () {
            @Override
            public void TuijianShiPinOnSuccess(TuijianshipinBean TuijianshipinBean) {
                data = TuijianshipinBean.getData ();
                tuijian_video_baseadapter = new Tuijian_Video_baseadapter (getActivity (), data);
                remenrev1.setAdapter (tuijian_video_baseadapter);
            }

            @Override
            public void TuijianShiPinOnError(Throwable Throwable) {
                Log.i ("推荐热门", Throwable.getMessage ());
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
