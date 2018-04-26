package com.example.liufan.xiangmu.duanzi.modle;

import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
<<<<<<< HEAD
=======
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle implements Modle{

<<<<<<< HEAD



    private CallbackData callbackData;
     public interface CallbackData {
         void setDZdata(DZListBean dZdata);
         void onFail(String e);
     }

     public void setCallbackData(CallbackData callbackData){
         this.callbackData=callbackData;
     }


    public void getDZData(String url, int page) {
        ApiService retrofit = RetrofitUtil.getInData().getRetrofit(url, ApiService.class);
        Observable<DZListBean> dzdata = retrofit.getDzdata("android","101",page+"");
        dzdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DZListBean>() {
                    @Override
                    public void accept(DZListBean dzListBean) throws Exception {
                        callbackData.setDZdata(dzListBean);
                    }
                });
    }
=======
    @Override
    public void getDZData(String url,String version ,int page, final ModelSF modelSF) {
        ApiService retrofit = RetrofitUtil.getInData().getRetrofit(url, ApiService.class);
        Observable<DZListBean> dzdata = retrofit.getDzdata("android",version,page+"");
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
>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d
}
