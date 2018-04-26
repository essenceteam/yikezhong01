package com.example.liufan.xiangmu.duanzi.presenter;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.modle.IModle;

import com.example.liufan.xiangmu.duanzi.modle.Modle;
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;




import retrofit2.http.HEAD;

/**
 * Created by liufan on 2018/4/24.
 */

public class IPresenter{


    private DuanZiIView duanZiIView;
    private  IModle iModle;

    public IPresenter(DuanZiIView duanZiIView) {
        this.duanZiIView = duanZiIView;
        this.iModle = new IModle();
    }



    public void getDZdata(String url,int page){
        iModle.getDZData(url, page);
        iModle.setCallbackData(new IModle.CallbackData() {
            @Override
            public void setDZdata(DZListBean dZdata) {
                duanZiIView.dzOnSuccess(dZdata);
            }

            @Override
            public void onFail(String e) {
                duanZiIView.dzOnFail(e);
            }
        });
    }



}


