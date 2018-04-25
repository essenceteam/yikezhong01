package com.example.liufan.xiangmu.duanzi.presenter;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.modle.IModle;
import com.example.liufan.xiangmu.duanzi.modle.ModelSF;
import com.example.liufan.xiangmu.duanzi.modle.Modle;
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;

/**
 * Created by liufan on 2018/4/24.
 */

public class IPresenter implements Presenter {

    private Modle modle;
    private DuanZiIView duanZiIView;

    public IPresenter(DuanZiIView duanZiIView) {
        this.duanZiIView = duanZiIView;
        modle=new IModle();
    }

    @Override
    public void getDZData(String url, int page, ModelSF modelSF) {
        modle.getDZData(url, page, new ModelSF() {
            @Override
            public void onSuccess(Object object) {
                DZListBean dzListBean= (DZListBean) object;
                duanZiIView.dzOnSuccess(dzListBean);
            }

            @Override
            public void onFail(String e) {
                duanZiIView.dzOnFail(e);
            }
        });
    }
}
