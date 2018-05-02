package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.shipin.bean.YongHuzpBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * author:Created by WangZhiQiang on 2018/5/2.
 */

public class Video_yonghuzp_Adapter extends RecyclerView.Adapter<Video_yonghuzp_Adapter.MyyhzpHolber> {

    Context context;
    List<YongHuzpBean.DataBean> data;

    public Video_yonghuzp_Adapter(Context context, List<YongHuzpBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyyhzpHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_yhzp_adapter, parent, false);
        MyyhzpHolber myyhzpHolber = new MyyhzpHolber(view);
        return myyhzpHolber;
    }

    @Override
    public void onBindViewHolder(MyyhzpHolber holder, int position) {

        holder.video_yhzp_tou.setImageResource(R.drawable.ic_launcher_background);
        holder.video_yhzp_itme_1.setText(data.get(position).getCreateTime());
        holder.video_yhzp_name.setText("影星");
        holder.video_yhzp_sp.setUp(data.get(position).getVideoUrl(),JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,data.get(position).getWid()+"");
        Picasso.with(context)
                .load(data.get(position).getCover())
                .into(holder.video_yhzp_sp.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyyhzpHolber extends RecyclerView.ViewHolder{

        private final ImageView video_yhzp_tou;
        private final TextView video_yhzp_name;
        private final TextView video_yhzp_mz;
        private final TextView video_yhzp_itme_1;
        private final JZVideoPlayerStandard video_yhzp_sp;
        private final TextView video_yhzp_qzsgs;

        public MyyhzpHolber(View itemView) {
            super(itemView);
            video_yhzp_tou = itemView.findViewById(R.id.video_yhzp_tou);
            video_yhzp_name = itemView.findViewById(R.id.video_yhzp_name);
            video_yhzp_mz = itemView.findViewById(R.id.video_yhzp_mz);
            video_yhzp_itme_1 = itemView.findViewById(R.id.video_yhzp_itme_1);
            video_yhzp_sp = itemView.findViewById(R.id.video_yhzp_sp);
            video_yhzp_qzsgs = itemView.findViewById(R.id.video_yhzp_qzsgs);
        }
    }
}
