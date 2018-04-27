package com.example.liufan.xiangmu.shipin.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.shipin.Video_Api_Service;
import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.example.liufan.xiangmu.shipin.bean.Video_FuJinBean;
import com.example.liufan.xiangmu.shipin.bean.Video_ReMenBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class Video_Modle {


    public void getVideo_HQSP(String source, String appVersion,String uid , String type, String page, final Video_Moudle_hui video_moudle_hui) {
        RetrofitUtil inData = RetrofitUtil.getInData ();
        Video_Api_Service retrofit = inData.getRetrofit(API.Url, Video_Api_Service.class);
        Observable<HQSPBean> video_hqsp = retrofit.getVideo_HQSP(source,appVersion,uid, type, page);
        video_hqsp.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HQSPBean>() {
                    @Override
                    public void accept(HQSPBean hqspBean) throws Exception {
                        video_moudle_hui.onSuccess(hqspBean);
                    }
                });
    }

    public void getVideo_ReMen(String token,String source,String appVersion,String page,final Video_Moudle_hui video_moudle_hui){
        RetrofitUtil inData = RetrofitUtil.getInData ();
        Video_Api_Service retrofit = inData.getRetrofit(API.Url, Video_Api_Service.class);
        Observable<Video_ReMenBean> video_reMen = retrofit.getVideo_ReMen(token, source, appVersion, page);
        video_reMen.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Video_ReMenBean>() {
                    @Override
                    public void accept(Video_ReMenBean video_reMenBean) throws Exception {
                        video_moudle_hui.onSuccess(video_reMenBean);
                    }
                });
    }
    public void getVideo_FuJin(String token,String source,String appVersion,String latitude,String longitude, String page,final Video_Moudle_hui video_moudle_hui){
        RetrofitUtil inData = RetrofitUtil.getInData ();
        Video_Api_Service retrofit = inData.getRetrofit(API.Url, Video_Api_Service.class);
        final Observable<Video_FuJinBean> video_fuJin = retrofit.getVideo_FuJin(token, source, appVersion, latitude, longitude, page);
        video_fuJin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Video_FuJinBean>() {
                    @Override
                    public void accept(Video_FuJinBean video_fuJinBean) throws Exception {
                        video_moudle_hui.onSuccess(video_fuJinBean);
                    }
                });

    }

}
