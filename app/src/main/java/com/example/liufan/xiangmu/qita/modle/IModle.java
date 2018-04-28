package com.example.liufan.xiangmu.qita.modle;

import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.bean.AttentionBean;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.Publishan;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;


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


    //发布段子
    @Override
    public void Publishanarticle(String url, String uid, String content, String token, List<MultipartBody.Part> file , final Modle3 modle3) {
        inData = RetrofitUtil.getInData();
        ApiService retrofit = inData.getRetrofit(url, ApiService.class);
        final Observable<Publishan> android = retrofit.Publishanarticle("android", uid, content, token, "101", file);
        android.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Publishan>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Publishan value) {
                        modle3.PublishanarticleSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modle3.PublishanarticleError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
  //我的关注
    @Override
    public void Myattention(String url, String uid, String token, final Modle4 modle4) {
        inData = RetrofitUtil.getInData();
        ApiService retrofit = inData.getRetrofit(url, ApiService.class);
        final Observable<AttentionBean> android = retrofit.Attention("android", uid, token, "101");
        android.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionBean value) {
                        modle4.AttentionSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modle4.AttentionError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
