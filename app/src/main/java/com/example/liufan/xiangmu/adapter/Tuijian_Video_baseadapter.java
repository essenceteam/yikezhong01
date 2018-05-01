package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.activity.Tuijian_Xiangqing_Activity;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by lenovo on 2018/4/27.
 */

public class Tuijian_Video_baseadapter extends XRecyclerView.Adapter<Tuijian_Video_baseadapter.MyViewHodler> {
    private Context context;
    private List<TuijianshipinBean.DataBean> list;

    public Tuijian_Video_baseadapter(Context context, List<TuijianshipinBean.DataBean> list) {
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
    public void onBindViewHolder(MyViewHodler holder, final int position) {
        TuijianshipinBean.DataBean.UserBean user = list.get (position).getUser ();
        holder.re_men_item_name.setText (user.getNickname ());
        holder.re_men_item_time.setText (list.get (position).getCreateTime ());
        holder.re_men_item_title.setText (list.get (position).getWorkDesc ()+"");
        final String icon = user.getIcon ();
        if(icon.contains ("|")){
            String[] split = icon.split ("\\|");
            Picasso.with (context).load (split[0]).into (holder.re_men_item_sdv);
        }else{
            Picasso.with (context).load (icon).into (holder.re_men_item_sdv);
        }
       holder.re_men_item_sdv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
               int uid = list.get (position).getUid ();
                String nickname = list.get (position).getUser ().getNickname ();
                Intent Intent=new Intent (context, Tuijian_Xiangqing_Activity.class);
                Intent.putExtra ("uid",uid+"");
                Intent.putExtra ("img",icon);
               // Intent.putExtra ("name",nickname);
                context.startActivity (Intent);
            }
        });
        holder.re_men_item_jiecao.setUp (list.get (position).getVideoUrl (),JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Picasso.with (context)
                .load (list.get (position).getCover ())
                .into (holder.re_men_item_jiecao.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }
    class MyViewHodler extends RecyclerView.ViewHolder {
        public TextView re_men_item_name;
        public TextView re_men_item_time;
        public TextView re_men_item_title;
        public JZVideoPlayerStandard re_men_item_jiecao;
        public SimpleDraweeView re_men_item_sdv;
        public MyViewHodler(View itemView) {
            super (itemView);
            re_men_item_name = itemView.findViewById(R.id.re_men_item_name);
            re_men_item_time = itemView.findViewById(R.id.re_men_item_time);
            re_men_item_title = itemView.findViewById(R.id.re_men_item_title);
            re_men_item_jiecao = itemView.findViewById(R.id.re_men_item_jiecao);
            re_men_item_sdv = itemView.findViewById(R.id.re_men_item_sdv);
        }
    }
}
