package com.example.liufan.xiangmu.tuijain;

import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface TuijianApisevice {
    @GET("quarter/getVideos")
    Observable<TuijianshipinBean> getparmter(@Query ("source")String android, @Query ("appVersion")String ve, @Query ("page")int page,@Query ("type")String ty);
}
