package com.example.liufan.xiangmu.shipin;

import com.example.liufan.xiangmu.shipin.bean.HQSPBean;
import com.example.liufan.xiangmu.shipin.bean.Video_FuJinBean;
import com.example.liufan.xiangmu.shipin.bean.Video_ReMenBean;
import com.example.liufan.xiangmu.shipin.bean.YongHuzpBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by WangZhiQiang on 2018/4/25.
 */

public interface Video_Api_Service {
    //获取视频作品列表
    //https://www.zhaoapi.cn/quarter/getVideos?source=android&appVersion=101&uid=11080type=1&page=1
    @GET("quarter/getVideos")
    Observable<HQSPBean> getVideo_HQSP(@Query("source") String source, @Query("appVersion") String appVersion,@Query("uid") String uid, @Query("type")String type, @Query("page")String page);
    //热门视频
    //https://www.zhaoapi.cn/quarter/getHotVideos?token=F59DAFABFD3392862082B61174D823A6&source=android&appVersion=101&page=1
    @GET("quarter/getHotVideos")
    Observable<Video_ReMenBean> getVideo_ReMen(@Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion,@Query("page") String page);
    //附近视频
    //https://www.zhaoapi.cn/quarter/getNearVideos?token=F59DAFABFD3392862082B61174D823A6&source=android&appVersion=101&latitude=40.04710&longitude=116.3064&page=1
    @GET("quarter/getNearVideos")
    Observable<Video_FuJinBean> getVideo_FuJin(@Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion, @Query("latitude") String latitude, @Query("longitude") String longitude, @Query("page") String page);
    //用户信息
    //https://www.zhaoapi.cn/user/getUserInfo?source=android&appVersion=101&uid=1758
    //获取某个用户的作品列表
    //https://www.zhaoapi.cn/quarter/getUserVideos?source=android&appVersion=101&uid=1758&page=1
    @GET("quarter/getUserVideos")
    Observable<YongHuzpBean> getVideo_yonghuzp(@Query("source") String source,@Query("appVersion") String appVersion,@Query("uid") String uid,@Query("page") String page);
}