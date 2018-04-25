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

    public void getVideo_HQSP(String source, String appVersion, String type, String page) {
        video_Modle.getVideo_HQSP(source, appVersion, type, page, new Video_Moudle_hui() {
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
