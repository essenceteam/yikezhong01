package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;

/**
 * Created by liufan on 2018/4/25.
 */

public class LoginActivity extends BaesActivity implements View.OnClickListener{

    private Button wx_bt;
    private Button qq_bt;
    private TextView qita_te;
    private ImageView huitui_iv;

    @Override
    public int getlayout() {
        //加载布局
        return R.layout.login_zhu;
    }

    @Override
    public void getinit() {
        //微信登录
        wx_bt = findViewById(R.id.wx_bt);
        wx_bt.setOnClickListener(this);
        //QQ登录
        qq_bt = findViewById(R.id.QQ_bt);
        qq_bt.setOnClickListener(this);
        //其他登录
        qita_te = findViewById(R.id.qita_te);
        qita_te.setOnClickListener(this);
        //回退
        huitui_iv = findViewById(R.id.huitui_iv);
        huitui_iv.setOnClickListener(this);

    }

    @Override
    public void getdata() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wx_bt:
                break;
            case R.id.QQ_bt:
                break;
            case R.id.qita_te:
                Intent intent =new Intent(LoginActivity.this,QiTaActivity.class);
                startActivity(intent);
                break;
            case R.id.huitui_iv:
                finish();
                break;

        }
    }
}
