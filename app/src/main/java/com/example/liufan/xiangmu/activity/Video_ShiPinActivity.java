package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.util.Log;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * author:Created by WangZhiQiang on 2018/4/25.
 */

public class Video_ShiPinActivity extends BaesActivity{

    private JZVideoPlayerStandard jzVideoPlayerStandard ;

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
