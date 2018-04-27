package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * author:Created by WangZhiQiang on 2018/4/25.
 */

public class Video_ShiPinActivity extends BaesActivity{

    private JZVideoPlayerStandard jzVideoPlayerStandard ;
    private ImageView video_huiremenfujin;
    private ImageView video_xihuan;
    private ImageView video_buxihuan;
    private ImageView video_fenxiang;
    private ImageView video_touxiang;
    private TextView video_qiangshafa;

    @Override
    public int getlayout() {
        return R.layout.video_sp_view;
    }

    @Override
    public void getinit() {
        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        String icon = intent.getStringExtra("icon");
        String nickname = intent.getStringExtra("nickname");
        jzVideoPlayerStandard  = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        video_huiremenfujin = findViewById(R.id.video_huiremenfujin);
        video_xihuan = findViewById(R.id.video_xihuan);
        video_buxihuan = findViewById(R.id.video_buxihuan);
        video_fenxiang = findViewById(R.id.video_fenxiang);
        video_touxiang = findViewById(R.id.video_touxiang);
        video_qiangshafa = findViewById(R.id.video_qiangshafa);
        video_qiangshafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_ShiPinActivity.this, "想坐沙发？呵呵，你得先掏钱哟！", Toast.LENGTH_SHORT).show();
            }
        });

        video_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_ShiPinActivity.this, "点我干嘛！ 找揍啊？", Toast.LENGTH_SHORT).show();
            }
        });
        video_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_ShiPinActivity.this, "正在研发...", Toast.LENGTH_SHORT).show();
            }
        });
        video_buxihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_buxihuan.setImageResource(R.drawable.raw_14);
            }
        });
        video_xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_xihuan.setImageResource(R.drawable.raw_1499933215);
            }
        });
        video_huiremenfujin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Log.d("哈哈666", "getinit: "+videourl);
        //JC 视频播放的URl 地址 的方法是用到了setUP( URL , )
        jzVideoPlayerStandard.setUp(videourl, JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,nickname);
        //picass 图片加载框架
        Picasso.with(this)
                .load(icon)
                .into(jzVideoPlayerStandard.thumbImageView);
    }
    @Override
    public void getdata() {

    }

    /**
     * backPress函数判断了点击回退按钮的相应，
     * 如果全屏会退出全屏播放，如果不是全屏则会交给Activity
     */
    @Override
    public void onBackPressed() {
        if(JZVideoPlayerStandard.backPress()){
            return;
        }
        super.onBackPressed();
    }

    /**
     * 暂停 /失去焦点
     * Activity或者按Home键之后会视频就会releas(释放)
     */
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();
    }

}
