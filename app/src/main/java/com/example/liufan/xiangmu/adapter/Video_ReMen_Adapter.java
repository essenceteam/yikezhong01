package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/24.
 */

public class Video_ReMen_Adapter extends RecyclerView.Adapter<Video_ReMen_Adapter.Myviewholber> {

    Context context;
    List<HQSPBean.DataBean> data;

    public Video_ReMen_Adapter(Context context, List<HQSPBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }
    @Override
    public Myviewholber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_remen_adapter, null);
        Myviewholber myviewholber = new Myviewholber(view);
        return myviewholber;
    }
    @Override
    public void onBindViewHolder(Myviewholber holder, int position) {
        String icon = data.get(position).getUser().getIcon();
        if (icon != null) {
            Log.i("LLLLLLLLLLLLLD",""+icon);
            //创建将要下载的图片的URI
            Uri imageUri = Uri.parse(icon);
            holder.video_remen_xrecy_fresco.setImageURI(imageUri);
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class Myviewholber extends RecyclerView.ViewHolder{

        private final SimpleDraweeView video_remen_xrecy_fresco;

        public Myviewholber(View itemView) {
            super(itemView);
            video_remen_xrecy_fresco = itemView.findViewById(R.id.video_remen_xrecy_fresco);
        }
    }

}
