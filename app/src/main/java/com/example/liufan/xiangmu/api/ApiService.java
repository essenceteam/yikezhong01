package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.bean.LoginBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface ApiService {
   //登录接口
    @GET("user/login")
    Observable<LoginBean> Login(@Query("mobile") String mobile,@Query("password") String password);
}
