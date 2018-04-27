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
        jzVideoPlayerStandard  = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        Log.d("哈哈666", "getinit: "+videourl);
        //JC 视频播放的URl 地址 的方法是用到了setUP( URL , )
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"请闭眼");
        //picass 图片加载框架
        Picasso.with(this)
                .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
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
