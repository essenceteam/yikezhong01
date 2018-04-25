package com.example.liufan.xiangmu.duanzi.modle;

import com.example.liufan.xiangmu.api.ApiService;
import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liufan on 2018/4/24.
 */

public class IModle {


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
}
