package com.example.liufan.xiangmu.activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.qita.view.RegisterView;

public class RegisterActivity extends BaesActivity implements RegisterView{


    private EditText mobile_et;
    private EditText password_et;
    private Button register_bt;
    private ImageView back_reg;
    private TextView login_reg;

    @Override
    public int getlayout() {
        return R.layout.activity_register;
    }

    @Override
    public void getinit() {
        mobile_et = findViewById(R.id.mobile_et);
        password_et = findViewById(R.id.password_et);
        register_bt = findViewById(R.id.register_bt);
        back_reg = findViewById(R.id.back_reg);
        login_reg = findViewById(R.id.login_reg);
    }

    @Override
    public void getdata() {
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //控件获取值
                String mobile = mobile_et.getText().toString();
                String password = password_et.getText().toString();

            }
        });
        back_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,QiTaActivity.class));
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
