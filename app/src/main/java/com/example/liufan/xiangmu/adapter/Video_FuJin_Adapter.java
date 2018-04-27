package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.shipin.bean.Video_FuJinBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class Video_FuJin_Adapter extends RecyclerView.Adapter<Video_FuJin_Adapter.Myviewholber> {

    Context context;
    List<Video_FuJinBean.DataBean> data;
    private Itemclick item;
    public Video_FuJin_Adapter(Context context, List<Video_FuJinBean.DataBean>  data) {
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
    public void onBindViewHolder(final Myviewholber holder, final int position) {
        String cover = data.get(position).getUser().getIcon();
        if (cover != null) {
            Log.i("哈哈哈哈或",""+cover);
//            创建将要下载的图片的URI
            Picasso.with(context).load(cover).placeholder(R.drawable.ic_launcher_background).into(holder.video_remen_xrecy_iv);
        }
        //修改瀑布流随机高度
        Random random = new Random();
        ViewGroup.LayoutParams layoutParams = holder.video_remen_xrecy_iv.getLayoutParams();
        layoutParams.height=random.nextInt(200)+150;
        //layoutParams.width = 200;
        holder.video_remen_xrecy_iv.setLayoutParams(layoutParams);
        //item为接口的变量名
        if (item!=null){
            //holder为Myhodler holder的参数
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //调用接口的方法
                    item.itemclick(holder.itemView,position);
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class Myviewholber extends RecyclerView.ViewHolder{

        private final ImageView video_remen_xrecy_iv;

        public Myviewholber(View itemView) {
            super(itemView);
            video_remen_xrecy_iv = itemView.findViewById(R.id.video_remen_xrecy_iv);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void onItemClick(Itemclick item){
        this.item=item;
    }

}
