package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;

/**
 * author:Created by WangZhiQiang on 2018/4/28.
 */

public class video_yonghusp_xrecy extends RecyclerView.Adapter<video_yonghusp_xrecy.MyViewHolber> {

    Context context;

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_yonghu_adapter, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return  myViewHolber;
    }

    @Override
    public void onBindViewHolder(MyViewHolber holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolber extends RecyclerView.ViewHolder{
        public MyViewHolber(View itemView) {
            super(itemView);
        }
    }
}
