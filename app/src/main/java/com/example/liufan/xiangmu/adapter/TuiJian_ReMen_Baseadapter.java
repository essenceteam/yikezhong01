package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by lenovo on 2018/4/25.
 */

public class TuiJian_ReMen_Baseadapter extends XRecyclerView.Adapter<TuiJian_ReMen_Baseadapter.MyViewHodler> {
  private  Context context;
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
        return 0;
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        public MyViewHodler(View itemView) {
            super (itemView);
        }
    }
}