package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.util.Log;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class Video_YongHuShiPin extends BaesActivity {
    @Override
    public int getlayout() {
        return R.layout.video_yonghushipin_view;
    }

    @Override
    public void getinit() {
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        Log.i("LLLLLUID","用户的UID"+uid);

    }

    @Override
    public void getdata() {
    }
}
