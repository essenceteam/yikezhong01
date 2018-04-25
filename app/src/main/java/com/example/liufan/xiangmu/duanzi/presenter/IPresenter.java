package com.example.liufan.xiangmu.duanzi.presenter;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.modle.IModle;
<<<<<<< HEAD
import com.example.liufan.xiangmu.duanzi.modle.ModelSF;
import com.example.liufan.xiangmu.duanzi.modle.Modle;
=======
>>>>>>> e6510ef3994965cac763fc05517f91b5f6041406
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;

/**
 * Created by liufan on 2018/4/24.
 */

<<<<<<< HEAD
public class IPresenter implements Presenter {

    private Modle modle;
    private DuanZiIView duanZiIView;
=======
public class IPresenter {

    private DuanZiIView duanZiIView;
    private IModle modle;
>>>>>>> e6510ef3994965cac763fc05517f91b5f6041406

    public IPresenter(DuanZiIView duanZiIView) {
        this.duanZiIView = duanZiIView;
        modle=new IModle();
    }

<<<<<<< HEAD
    @Override
    public void getDZData(String url, int page, ModelSF modelSF) {
        modle.getDZData(url, page, new ModelSF() {
            @Override
            public void onSuccess(Object object) {
                DZListBean dzListBean= (DZListBean) object;
                duanZiIView.dzOnSuccess(dzListBean);
=======
    public void getDZdata(String url,int page){
        modle.getDZData(url, page);
        modle.setCallbackData(new IModle.CallbackData() {
            @Override
            public void setDZdata(DZListBean dZdata) {
                duanZiIView.dzOnSuccess(dZdata);
>>>>>>> e6510ef3994965cac763fc05517f91b5f6041406
            }

            @Override
            public void onFail(String e) {
                duanZiIView.dzOnFail(e);
            }
        });
<<<<<<< HEAD
    }
=======

    }


>>>>>>> e6510ef3994965cac763fc05517f91b5f6041406
}
