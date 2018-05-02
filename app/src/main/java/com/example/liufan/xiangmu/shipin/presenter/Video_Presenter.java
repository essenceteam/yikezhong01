package com.example.liufan.xiangmu.shipin.presenter;

import com.example.liufan.xiangmu.shipin.modle.Video_Modle;
import com.example.liufan.xiangmu.shipin.modle.Video_Moudle_hui;
import com.example.liufan.xiangmu.shipin.view.Video_OnView;

/**
 * Created by liufan on 2018/4/24.
 */

public class Video_Presenter extends BaseVideo_Presenters<Video_OnView> {

    private Video_Modle video_Modle;

    public Video_Presenter(Video_OnView video_onView) {
        super(video_onView);
        video_Modle = new Video_Modle();
    }

    public void getVideo_HQSP(String source, String appVersion,String uid ,String type, String page) {
        video_Modle.getVideo_HQSP(source, appVersion, uid ,type, page, new Video_Moudle_hui() {
            @Override
            public void onError(String ss) {

            }

            @Override
            public void onSuccess(Object object) {
//                Log.i("LLC你好","三国杀手电筒色弱");
                v.onSuccess(object);
            }
        });
    }

    public void getVideo_ReMen(String token,String source, String appVersion, String page){
        video_Modle.getVideo_ReMen(token, source, appVersion, page, new Video_Moudle_hui() {
            @Override
            public void onError(String ss) {

            }

            @Override
            public void onSuccess(Object object) {
                v.onSuccess(object);
            }
        });
    }
    public void getVideo_FuJin(String token,String source,String appVersion,String latitude,String longitude, String page){
        video_Modle.getVideo_FuJin(token, source, appVersion, latitude, longitude, page, new Video_Moudle_hui() {
            @Override
            public void onError(String ss) {

            }

            @Override
            public void onSuccess(Object object) {
                v.onSuccess(object);
            }
        });
    }

    public void getVideo_YongHuzp(String source, String appVersion, String uid , String page){
        video_Modle.getYongHuzp(source, appVersion, uid, page, new Video_Moudle_hui() {
            @Override
            public void onError(String ss) {

            }

            @Override
            public void onSuccess(Object object) {
                v.onSuccess(object);
            }
        });
    }


}
