package com.example.liufan.xiangmu.activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.qita.view.RegisterView;

public class RegisterActivity extends BaesActivity implements RegisterView{


    private EditText mobile_et;
    private EditText password_et;
    private Button register_bt;
    private ImageView fanhui;

    @Override
    public int getlayout() {
        return R.layout.activity_register;
    }

    @Override
    public void getinit() {
        mobile_et = findViewById(R.id.mobile_et);
        password_et = findViewById(R.id.password_et);
        register_bt = findViewById(R.id.register_bt);
        fanhui = findViewById(R.id.fanhui);
    }

    @Override
    public void getdata() {
        //注册的按钮
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //控件获取值
                String mobile = mobile_et.getText().toString();
                String password = password_et.getText().toString();

            }
        });
        //回退的点击事件
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void RegisterError(String ss) {

    }

    @Override
    public void RegisterSuccess(RegisterBean registerBean) {
           //获取网络注册的结果
    }
}
