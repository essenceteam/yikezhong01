package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface ApiService {


   @GET("quarter/getJokes")
   Observable<DZListBean> getDzdata(@Query("page") int page);

   //登录接口
    @GET("user/login")
    Observable<LoginBean> Login(@Query("mobile") String mobile,@Query("password") String password);
}
