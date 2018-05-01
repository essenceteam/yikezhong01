package com.example.liufan.xiangmu.tuijain;

import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianguanzhuBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.Tuijianyonghu_Xiangqing_bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface TuijianApisevice {
    @GET("quarter/getVideos")
    Observable<TuijianshipinBean> getparmter(@Query ("source")String android, @Query ("appVersion")String ve, @Query ("page")int page,@Query ("type")String ty);
    @GET("quarter/getVideos")
    Observable<TuijianguanzhuBean> getparmter1(@Query ("source")String android, @Query ("appVersion")String ve, @Query ("page")int page, @Query ("type")String ty, @Query ("uid")String uid);
    @GET("quarter/getUserVideos")
    Observable<Tuijianyonghu_Xiangqing_bean> getparmter2(@Query ("source")String android, @Query ("appVersion")String ve, @Query ("page")int page, @Query ("uid")String uid);

}
