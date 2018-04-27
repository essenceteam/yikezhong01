package com.example.liufan.xiangmu.tuijain.modle;

import android.util.Log;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.tuijain.TuijianApisevice;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianguanzhuBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle {
    //轮播图
    public void  getlunbo(final Modle IModle){
        RetrofitUtil data = RetrofitUtil.getInData ();
        ApiService retrofit = data.getRetrofit (API.Url, ApiService.class);
        Observable<LunBoBean> getlunbo = retrofit.getlunbo ();
        getlunbo.subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<LunBoBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LunBoBean value) {
                        Log.i ("轮播图",value.getMsg ());
                        if(IModle!=null){
                            IModle.TuijianOnSuccess (value);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i ("轮播图",e.getMessage ());
                        IModle.TuijianOnError (e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //热门视频
    public void  getvidio(String android, int page,String ty, final ShiPinModle ShiPinModle){
        RetrofitUtil inData = RetrofitUtil.getInData ();
        TuijianApisevice retrofit = inData.getRetrofit (API.Url, TuijianApisevice.class);
        Observable<TuijianshipinBean> getparmter = retrofit.getparmter (android, "101", page,ty);
        getparmter.subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<TuijianshipinBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianshipinBean value) {
                        if(ShiPinModle!=null){
                            ShiPinModle.TuijianShiPinOnSuccess (value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(ShiPinModle!=null){
                            ShiPinModle.TuijianShiPinOnError (e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    //关注视频
    public void  getvidio1(String android, int page,String ty,String uid, final GuanzhuModle GuanzhuModle){
        RetrofitUtil inData = RetrofitUtil.getInData ();
        TuijianApisevice retrofit = inData.getRetrofit (API.Url, TuijianApisevice.class);
        Observable<TuijianguanzhuBean> getparmter = retrofit.getparmter1 (android, "101", page,ty,uid);
        getparmter.subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<TuijianguanzhuBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianguanzhuBean value) {
                        if (GuanzhuModle!=null){
                            GuanzhuModle.TuijianShiPinOnSuccess (value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (GuanzhuModle!=null){
                            GuanzhuModle.TuijianShiPinOnError (e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
