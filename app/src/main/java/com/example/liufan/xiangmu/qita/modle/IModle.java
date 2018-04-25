package com.example.liufan.xiangmu.qita.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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
         Observable<LoginBean> login = retrofit.Login("android",mobile, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        modle1.okLoadSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modle1.okLoadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
//注册的方法
    @Override
    public void Register(String url, String mobile, String password, final Modle2 modle2) {
        inData = RetrofitUtil.getInData();
        ApiService retrofit = inData.getRetrofit(url, ApiService.class);
         Observable<RegisterBean> register = retrofit.Register("android","0", mobile, password);
         register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean value) {
                        modle2.okLoadSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modle2.okLoadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
