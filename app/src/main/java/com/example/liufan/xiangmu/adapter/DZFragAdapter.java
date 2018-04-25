package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author:Created by Administrator on 2018/4/25.
 */

public class DZFragAdapter extends RecyclerView.Adapter<DZFragAdapter.DZviewHolder> {

    List<DZListBean.DataBean> list;
    Context context;

    public DZFragAdapter(List<DZListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DZviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(context).inflate(R.layout.dzadapter, null);
        DZviewHolder holder = new DZviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DZviewHolder holder, int position) {

        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //设置需要下载的图片地址
                .setUri(list.get(position).getUser().getIcon()+"")
                //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                //构建
                .build();
        holder.titleHead.setController(controller);
        holder.nameTv.setText(list.get(position).getUser().getNickname()+"");
        holder.dateTv.setText(list.get(position).getCreateTime());
        holder.getShuoshuoTv().setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size()<1?0:list.size();
    }

    class DZviewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView titleHead;
        private TextView nameTv;
        private TextView dateTv;
        private TextView shuoshuoTv;
        public DZviewHolder(View itemView) {
            super(itemView);
            titleHead=itemView.findViewById(R.id.title_head);
            nameTv=itemView.findViewById(R.id.name_tv);
            dateTv=itemView.findViewById(R.id.date_tv);
            shuoshuoTv=itemView.findViewById(R.id.content_tv);
        }

        public SimpleDraweeView getTitleHead() {
            return titleHead;
        }

        public TextView getNameTv() {
            return nameTv;
        }

        public TextView getDateTv() {
            return dateTv;
        }

        public TextView getShuoshuoTv() {
            return shuoshuoTv;
        }
    }
}
