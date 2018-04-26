package com.example.liufan.xiangmu.duanzi.presenter;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.modle.IModle;

import com.example.liufan.xiangmu.duanzi.modle.ModelSF;
import com.example.liufan.xiangmu.duanzi.modle.Modle;


import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;
import com.example.liufan.xiangmu.fragment.CrosstalkFragment;

/**
 * Created by liufan on 2018/4/24.
 */
import retrofit2.http.HEAD;

public class IPresenter implements Presenter {

    private Modle modle;
    private DuanZiIView duanZiIView;
    public IPresenter(DuanZiIView duanZiIView) {
        this.duanZiIView = duanZiIView;
        modle = new IModle();
    }

        @Override
        public void getDZData(String url, String version, int page, final CrosstalkFragment crosstalkFragment) {
            modle.getDZData(url, version,page, new ModelSF() {
                @Override
                public void onSuccess(Object object) {
                    crosstalkFragment.dzOnSuccess((DZListBean) object);
                }

                @Override
                public void onFail(String e) {
                    crosstalkFragment.dzOnFail(e);
                }
            });

}

}
