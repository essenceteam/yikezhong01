package com.example.liufan.xiangmu.activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.presenter.IPresenter;
import com.example.liufan.xiangmu.qita.view.LoginView;

public class QiTaActivity extends BaesActivity implements LoginView{


    private EditText mobile_et;
    private EditText password_et;
    private Button login_bt;
    private TextView login_reg;
    private ImageView fanhui;

    @Override
    public int getlayout() {
        return R.layout.login;
    }

    @Override
    public void getinit() {
        //获取账号控件
        mobile_et = findViewById(R.id.mobile_et);
        //获取密码控件
        password_et = findViewById(R.id.password_et);
        //登录按钮
        login_bt = findViewById(R.id.login_bt);
        //登录页面的注册按钮
        login_reg = findViewById(R.id.login_reg);
        fanhui = findViewById(R.id.fanhui);

    }

    @Override
    public void getdata() {
        //登录的点击事件
    login_bt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
           String mobile = mobile_et.getText().toString();
           String password = password_et.getText().toString();
          IPresenter iPresenter = new IPresenter();
          iPresenter.Login(new IModle(),mobile,password,QiTaActivity.this);
      }
  });
    //注册的点击事件
        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(QiTaActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void ViewLoadError(String ss) {

    }

    @Override
    public void ViewLoadSuccess(LoginBean loginBean) {
        //获取登录注册的结果
        int uid = loginBean.getData().getUid();
        String token = loginBean.getData().getToken();
        SharedPreferences sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("bo",true);
        edit.putInt("uid",uid);
        edit.putString("token",token);
        edit.commit();
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
}
