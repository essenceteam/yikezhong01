package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.tuijain.modle.Bean.Tuijianyonghu_Xiangqing_bean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

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
        View view = LayoutInflater.from (context).inflate (R.layout.tuijian_xiangqing_layout, parent, false);
        MyViewHodler MyViewHodler=new MyViewHodler (view);
        return MyViewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {

        String cover = list.get (position).getCover ();
        if (cover.contains ("|")){
            if(cover.equals ("")){
                String[] split = cover.split ("\\|");
                Picasso.with (context).load (split[0]).into (holder.sdv4);
            }else{
                int resourceId = R.mipmap.ic_launcher;
                Picasso.with(context).load(resourceId).into(holder.sdv4);
            }

        }else{
            if(cover.equals ("")){
                int resourceId = R.mipmap.ic_launcher;
                Picasso.with(context).load(resourceId).into(holder.sdv4);

            }else{
                Picasso.with (context).load (cover).into (holder.sdv4);
            }


        }
        //holder.t_ncc.setText (list.get (position).getWorkDesc ());
        holder.item_1.setText (list.get (position).getCreateTime ());
        holder.xj.setText (list.get (position).getWorkDesc ());
        holder.img_sp.setUp (list.get (position).getVideoUrl (),JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Picasso.with (context).load (list.get (position).getCover ()).into (holder.img_sp.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }
    class MyViewHodler extends RecyclerView.ViewHolder {

        private final ImageView sdv4;
        private final TextView t_ncc;
        private final TextView item_1;
        private final TextView xj;
        private final JZVideoPlayerStandard img_sp;

        public MyViewHodler(View itemView) {
                super (itemView);
            sdv4 = itemView.findViewById (R.id.sdv4);
            t_ncc = itemView.findViewById (R.id.t_ncc);
            item_1 = itemView.findViewById (R.id.itme_1);
            xj = itemView.findViewById (R.id.xj);
            img_sp = itemView.findViewById (R.id.img_sp);


            }
    }
}
