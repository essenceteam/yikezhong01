package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.tuijain.modle.Bean.Tuijianyonghu_Xiangqing_bean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by lenovo on 2018/4/28.
 */

public class Tuijian_xiangqing_baseadapter extends XRecyclerView.Adapter<Tuijian_xiangqing_baseadapter.MyViewHodler> {
    private Context context;
    private List<Tuijianyonghu_Xiangqing_bean.DataBean> list;

    public Tuijian_xiangqing_baseadapter(Context context, List<Tuijianyonghu_Xiangqing_bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.tuijian_renmen_item_layout, parent, false);
        MyViewHodler MyViewHodler=new MyViewHodler (view);
        return MyViewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
            public MyViewHodler(View itemView) {
                super (itemView);
        }
    }
}
