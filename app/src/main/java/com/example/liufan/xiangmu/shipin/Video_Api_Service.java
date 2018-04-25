package com.example.liufan.xiangmu.shipin;

import com.example.liufan.xiangmu.shipin.bean.HQSPBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by WangZhiQiang on 2018/4/25.
 */

public interface Video_Api_Service {
    //获取视频作品列表
    //https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=101&type=1&page=1
    @GET("quarter/getVideos")
    Observable<HQSPBean> getVideo_HQSP(@Query("source") String source, @Query("appVersion") String appVersion, @Query("type")String type, @Query("page")String page);
}