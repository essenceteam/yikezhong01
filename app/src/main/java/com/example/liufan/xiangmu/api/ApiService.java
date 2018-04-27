package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.Publishan;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
    @GET("quarter/getAd")
    Observable<LunBoBean> getlunbo();

   //注册接口
    @GET("quarter/register")
    Observable<RegisterBean> Register(@Query("source") String android,@Query("regType") String regType, @Query("mobile") String mobile, @Query("password") String password);
   //发布段子
    @Multipart
    @POST("quarter/publishJoke")
    Observable<Publishan> Publishanarticle(@Query("source") String android, @Query("uid") String uid, @Query("content") String content, @Query("token") String token, @Query("appVersion") String appVersion, @Part List<MultipartBody.Part> file);
}
