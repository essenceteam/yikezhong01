package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by lenovo on 2018/4/25.
 */

public class TuiJian_ReMen_Baseadapter extends XRecyclerView.Adapter<TuiJian_ReMen_Baseadapter.MyViewHodler> {
  private  Context context;
  private List<TuijianshipinBean.DataBean>list;

    public TuiJian_ReMen_Baseadapter(Context context, List<TuijianshipinBean.DataBean> list) {
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
            ImageView userimg  = itemView.findViewById (R.id.userimg);
            TextView username = itemView.findViewById (R.id.username);
            TextView usertime = itemView.findViewById (R.id.usertime);
            ImageView zidingyi = itemView.findViewById (R.id.zidingyi);

//            JCVideoPlayerStandard player_list_tuijian = itemView.findViewById (R.id.player_list_tuijian);
           // player_list_tuijian.setUp ("", JCVideoPlayer.SCREEN_LAYOUT_LIST,"");

        }
    }
}
