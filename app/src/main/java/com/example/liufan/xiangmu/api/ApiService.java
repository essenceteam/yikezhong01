package com.example.liufan.xiangmu.api;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface ApiService {

    @POST
    @FormUrlEncoded
    Observable<DZListBean> getDZdata(@Url String url, @FieldMap  Map<String,String> map);
}
