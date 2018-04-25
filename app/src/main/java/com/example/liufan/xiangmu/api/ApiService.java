package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface ApiService {

   //推荐广告
   @GET("quarter/getJokes")
   Observable<DZListBean> getDzdata(@Query("source") String android,@Query("appVersion") String version,@Query("page") String page);

   //登录接口
    @GET("user/login")
    Observable<LoginBean> Login(@Query("source") String android,@Query("mobile") String mobile,@Query("password") String password);
   //注册接口
    @GET("quarter/register")
    Observable<RegisterBean> Register(@Query("source") String android,@Query("regType") String regType, @Query("mobile") String mobile, @Query("password") String password);
}
