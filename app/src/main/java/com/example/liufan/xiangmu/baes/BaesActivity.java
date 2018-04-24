package com.example.liufan.xiangmu.baes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.liufan.xiangmu.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by liufan on 2018/4/24.
 */

public abstract class BaesActivity extends AutoLayoutActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
    }
    //获取布局文件
    public abstract int getlayout();
    //获取控件
    public abstract void getinit();
    //逻辑代码
    public abstract void getdata();

}
