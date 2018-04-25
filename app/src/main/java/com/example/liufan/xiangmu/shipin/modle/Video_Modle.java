package com.example.liufan.xiangmu.shipin.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.shipin.Video_Api_Service;
import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class Video_Modle implements VideoI_Modle {

    @Override
    public void getVideo_HQSP(String source, String appVersion, String type, String page, final Video_Moudle_hui video_moudle_hui) {
        RetrofitUtil inData = RetrofitUtil.getInData ();
        Video_Api_Service retrofit = inData.getRetrofit(API.Url, Video_Api_Service.class);
        Observable<HQSPBean> video_hqsp = retrofit.getVideo_HQSP(source, appVersion, type, page);
        video_hqsp.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HQSPBean>() {
                    @Override
                    public void accept(HQSPBean hqspBean) throws Exception {
                        video_moudle_hui.onSuccess(hqspBean);
                    }
                });
    }
}
