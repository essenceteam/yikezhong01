package com.example.liufan.xiangmu.duanzi.modle;

import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle implements Modle {

    @Override
    public void getDZData(String url, int page, final ModelSF modelSF) {
        ApiService retrofit = RetrofitUtil.getInData().getRetrofit(url, ApiService.class);
        Observable<DZListBean> dzdata = retrofit.getDzdata(page);
        dzdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DZListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DZListBean value) {
                        modelSF.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                    modelSF.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
