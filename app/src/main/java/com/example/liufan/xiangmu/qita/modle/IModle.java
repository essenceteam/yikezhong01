package com.example.liufan.xiangmu.qita.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle implements Modle{

    private RetrofitUtil inData;

    @Override
    //登录的方法
    public void Login(String url, String mobile, String password, final Modle1 modle1) {
        inData = RetrofitUtil.getInData();
         ApiService retrofit = inData.getRetrofit(url, ApiService.class);
         Observable<LoginBean> login = retrofit.Login(mobile, password);
        login.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginBean>() {
                    @Override
                    public void call(LoginBean loginBean) {
                        modle1.okLoadSuccess(loginBean);
                    }
                });
    }
}
