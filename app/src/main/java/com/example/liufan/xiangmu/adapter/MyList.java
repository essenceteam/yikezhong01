package com.example.liufan.xiangmu.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.bean.AttentionBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liufan on 2018/4/28.
 */

public class MyList extends BaseAdapter {
    private final Context context;
    private final List<AttentionBean.DataBean> data;
    private ImageView gz_iv;
    private TextView gz_te;
    private TextView gz_te1;
    private TextView gz_sj;

    public MyList(Context context, List<AttentionBean.DataBean> data){
   this.context=context;
   this.data=data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=View.inflate(context, R.layout.listview_layout,null);
        }
        gz_iv = convertView.findViewById(R.id.gz_iv);
        gz_te = convertView.findViewById(R.id.gz_te);
        gz_te1 = convertView.findViewById(R.id.gz_te1);
        gz_sj = convertView.findViewById(R.id.gz_sj);
        Uri uri=Uri.parse(data.get(position).getIcon()+"");
        Picasso.with(context).load(uri).into(gz_iv);
        gz_te.setText("阿诺玛斯丁");
        gz_te1.setText("吃货们快戳我!");
        gz_te.setText(data.get(position).getCreatetime());
        return convertView;
    }


}
