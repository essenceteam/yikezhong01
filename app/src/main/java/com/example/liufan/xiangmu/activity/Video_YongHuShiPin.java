package com.example.liufan.xiangmu.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.Video_yonghuzp_Adapter;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.shipin.bean.YongHuzpBean;
import com.example.liufan.xiangmu.shipin.presenter.Video_Presenter;
import com.example.liufan.xiangmu.shipin.view.Video_OnView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class Video_YongHuShiPin extends BaesActivity implements Video_OnView {
    @BindView(R.id.video_yonghu_fanhui)
    ImageView videoYonghuFanhui;
    @BindView(R.id.video_yonghu_fenxiang)
    ImageView videoYonghuFenxiang;
    @BindView(R.id.sdv_3)
    SimpleDraweeView sdv3;
    @BindView(R.id.video_yonghu_fensi)
    TextView videoYonghuFensi;
    @BindView(R.id.video_yonghu_fengexian)
    TextView videoYonghuFengexian;
    @BindView(R.id.video_yonghu_guanzu)
    TextView videoYonghuGuanzu;
    @BindView(R.id.video_yonghu_tianjiaguanzu)
    TextView videoYonghuTianjiaguanzu;
    @BindView(R.id.video_yonghu_xrecy)
    XRecyclerView video_yonghu_xrecy;
    private Video_Presenter video_presenter;

    @Override
    public int getlayout() {
        return R.layout.video_yonghu_view;
    }

    @Override
    public void getinit() {
        ButterKnife.bind(this);
    }

    @Override
    public void getdata() {

        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        Log.i("LLLLLUID", "用户的UID" + uid);
/**
 * 调用p
 */
        video_presenter = new Video_Presenter(this);
        video_presenter.getVideo_YongHuzp("android","101",uid,"1");

        /**
         * 布局管理器
         */
        video_yonghu_xrecy.setLayoutManager(new LinearLayoutManager(this));

        videoYonghuFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        videoYonghuFenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_YongHuShiPin.this, "研究中..", Toast.LENGTH_SHORT).show();
            }
        });
        videoYonghuFensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_YongHuShiPin.this, "正在逐渐增加..", Toast.LENGTH_SHORT).show();
            }
        });
        videoYonghuGuanzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_YongHuShiPin.this, "已关注..", Toast.LENGTH_SHORT).show();
            }
        });
        videoYonghuTianjiaguanzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Video_YongHuShiPin.this, "已赞..", Toast.LENGTH_SHORT).show();
            }
        });
//        video_yonghu_xrecy.setLayoutManager(new LinearLayoutManager(this));
//        video_yonghusp_xrecy video_yonghusp_xrecy = new video_yonghusp_xrecy();
//        video_yonghu_xrecy.setAdapter(video_yonghusp_xrecy);

    }

    @Override
    public void onError(String ss) {

    }

    @Override
    public void onSuccess(Object object) {
        Log.i("LLLLLLLLLs","师范生拉科技发搜狗");
        YongHuzpBean yongHuzpBean = (YongHuzpBean) object;
        List<YongHuzpBean.DataBean> data = yongHuzpBean.getData();
        Log.i("LLLLLLLLLs",""+data.get(1).getCover());
        Video_yonghuzp_Adapter video_yonghuzp_adapter = new Video_yonghuzp_Adapter(Video_YongHuShiPin.this,data);
        video_yonghu_xrecy.setAdapter(video_yonghuzp_adapter);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}
