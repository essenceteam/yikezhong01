package com.example.liufan.xiangmu.activity;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.MyList;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.AttentionBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.presenter.IPresenter;
import com.example.liufan.xiangmu.qita.view.AttentionView;

import java.util.List;

public class MyAttentionActivity extends BaesActivity implements AttentionView{

    private TextView fh_te;
    private TextView rm_tb;
    private ListView lv;
    private int uid;
    String token1;
    private String token;
    int uid1;
    @Override
    public int getlayout() {
        return R.layout.activity_my_attention;
    }

    @Override
    public void getinit() {
        fh_te = findViewById(R.id.fh_te);
        rm_tb = findViewById(R.id.rm_tb);
        lv = findViewById(R.id.lv);
    }

    @Override
    public void getdata() {
         SharedPreferences user = getSharedPreferences("USER", Context.MODE_PRIVATE);
         boolean bo = user.getBoolean("bo", true);
         if (bo==true){
             uid = user.getInt("uid",uid1);
             token = user.getString("token", token1);
             IPresenter iPresenter = new IPresenter();
             iPresenter.Attention(new IModle(), API.Url,uid+"",token,this);
         }else {
             Toast.makeText(MyAttentionActivity.this,"请登录",Toast.LENGTH_LONG).show();
         }
        //返回
        fh_te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //热门
        rm_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //listView的适配器
    }

    @Override
    public void AttentionError(String ss) {

    }

    @Override
    public void AttentionSuccess(AttentionBean attentionBean) {
        List<AttentionBean.DataBean> data = attentionBean.getData();
        MyList myList = new MyList(MyAttentionActivity.this,data);
        lv.setAdapter(myList);
    }
}
