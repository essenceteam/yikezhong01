package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import com.example.liufan.xiangmu.bean.LoginBean;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface ApiService {


    @POST
    @FormUrlEncoded
    Observable<DZListBean> getDZdata(@Url String url, @FieldMap  Map<String,String> map);

   //登录接口
    @GET("user/login")
    Observable<LoginBean> Login(@Query("mobile") String mobile,@Query("password") String password);
}
