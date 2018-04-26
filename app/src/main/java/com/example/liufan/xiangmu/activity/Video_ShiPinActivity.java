package com.example.liufan.xiangmu.activity;

import android.content.Intent;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;

/**
 * author:Created by WangZhiQiang on 2018/4/25.
 */

public class Video_ShiPinActivity extends BaesActivity{
    @Override
    public int getlayout() {
        return R.layout.video_sp_view;
    }

    @Override
    public void getinit() {
        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
//        JCVideoPlayerStandard player_list_video = findViewById(R.id.player_list_video);

    }

    @Override
    public void getdata() {

    }
}
