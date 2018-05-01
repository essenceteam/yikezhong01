package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Tuijian_xiangqing_baseadapter;
import com.example.liufan.xiangmu.tuijain.View.IXiangqing;
import com.example.liufan.xiangmu.tuijain.modle.Bean.Tuijianyonghu_Xiangqing_bean;
import com.example.liufan.xiangmu.tuijain.presenter.Presenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Tuijian_Xiangqing_Activity extends AppCompatActivity {

    private ImageView sdv_3;
    private TextView t_fs;
    private TextView t_s;
    private TextView t_gz;
    private TextView jia_gz;
    private XRecyclerView x_v_shiping;
    private int page =1;
    private String uid;
    private String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tuijian__xiangqing);
        findviewbyid();
        Intent intent = getIntent ();
        uid = intent.getStringExtra ("uid");
        img = intent.getStringExtra ("img");
        if(img.contains ("|")){
            String[] split = img.split ("\\|");
            Picasso.with (Tuijian_Xiangqing_Activity.this).load (split[0]).into (sdv_3);
        }else{
            Picasso.with (Tuijian_Xiangqing_Activity.this).load (img).into (sdv_3);
        }
        getdata1();


    }
    public void findviewbyid(){
        sdv_3 = findViewById (R.id.sdv_3);
        t_fs = findViewById (R.id.t_fs);
        t_s = findViewById (R.id.t_s);
        t_gz = findViewById (R.id.t_gz);
        jia_gz = findViewById (R.id.jia_gz);
        x_v_shiping = findViewById (R.id.x_v_shiping);
    }
    public void getdata1(){
        x_v_shiping.setLayoutManager (new LinearLayoutManager (Tuijian_Xiangqing_Activity.this));
        Presenter Presenter=new Presenter ();
        Presenter.getxiangqingpresenter ("android", page, uid, new IXiangqing () {
            private List<Tuijianyonghu_Xiangqing_bean.DataBean> data;
            @Override
            public void Tuijian_xiangqing_OnSuccess(Tuijianyonghu_Xiangqing_bean Tuijianyonghu_Xiangqing_bean) {
                data = Tuijianyonghu_Xiangqing_bean.getData ();
                Log.i ("详情",data.get (0).getCover ());
                Tuijian_xiangqing_baseadapter Tuijian_xiangqing_baseadapter=new Tuijian_xiangqing_baseadapter (Tuijian_Xiangqing_Activity.this,data);
                x_v_shiping.setAdapter (Tuijian_xiangqing_baseadapter);


            }

            @Override
            public void Tuijian_xiangqing_OnError(Throwable Throwable) {

            }
        });
    }
}
