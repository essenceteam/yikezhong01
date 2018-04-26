package com.example.liufan.xiangmu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.activity.CreationActivity;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.fragment.AttentionFragment;
import com.example.liufan.xiangmu.fragment.CrosstalkFragment;
import com.example.liufan.xiangmu.fragment.RecommendFragment;
import com.example.liufan.xiangmu.fragment.VideoFragment;

public class MainActivity extends BaesActivity {

    private RadioGroup rg;
    private RecommendFragment recommendFragment;
    private VideoFragment videoFragment;
    private AttentionFragment attentionFragment;
    private CrosstalkFragment crosstalkFragment;
    private TextView head_te;
    private ImageView head_iv1;

    @Override
    public int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void getinit() {
        rg = findViewById(R.id.rg);
        head_te = findViewById(R.id.head_te);
        head_iv1 = findViewById(R.id.head_iv1);
    }

    @Override
    public void getdata() {
        //这是推荐的fragment
        recommendFragment = new RecommendFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,recommendFragment).commit();
        //RadioGroup的点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Hined();
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                switch (checkedId){
                    case R.id.rb1:
                        //推荐
                        supportFragmentManager.beginTransaction().show(recommendFragment).commit();
                        head_te.setText("推荐");
                        break;
                    case R.id.rb2:
                        //段子
                        if (crosstalkFragment==null){
                            crosstalkFragment = new CrosstalkFragment();
                            supportFragmentManager.beginTransaction().add(R.id.fl,crosstalkFragment).commit();
                        }else {
                            supportFragmentManager.beginTransaction().show(crosstalkFragment).commit();
                        }
                        head_te.setText("段子");
                        break;
                    case R.id.rb3:
                        //视频
                        if (videoFragment==null){
                            videoFragment = new VideoFragment();
                            supportFragmentManager.beginTransaction().add(R.id.fl,videoFragment).commit();
                        }else {
                            supportFragmentManager.beginTransaction().show(videoFragment).commit();
                        }
                        head_te.setText("视频");
                        break;
                    case R.id.rb4:
                        //关注
                        if (attentionFragment==null){
                            attentionFragment = new AttentionFragment();
                            supportFragmentManager.beginTransaction().add(R.id.fl,attentionFragment).commit();
                        }else {
                            supportFragmentManager.beginTransaction().show(attentionFragment).commit();
                        }
                        head_te.setText("关注");
                        break;
                }
            }
        });
        //创作的点击事件
        head_iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreationActivity.class);
                startActivity(intent);
            }
        });
    }


    //fragment的隐藏的方法
    public void Hined(){
        if (recommendFragment!=null&&recommendFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(recommendFragment).commit();
        }
        if (crosstalkFragment!=null&&crosstalkFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(crosstalkFragment).commit();
        }
        if (videoFragment!=null&&videoFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
        }
        if (attentionFragment!=null&&attentionFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(attentionFragment).commit();
        }

    }
}
