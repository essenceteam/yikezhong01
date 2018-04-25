package com.example.liufan.xiangmu.duanzi.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle implements Modle {

    @Override
    public void getDZData(String url, Class<ApiService> cc) {
        RetrofitUtil inData = RetrofitUtil.getInData();
        ApiService retrofit = inData.getRetrofit(API.Url, cc);
        Map<String,String> map = new HashMap<>();
//        map.put()



//        retrofit.getDZdata(API.Url,)


    }
}
