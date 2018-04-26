package com.example.liufan.xiangmu.duanzi.presenter;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;
import com.example.liufan.xiangmu.duanzi.modle.IModle;
<<<<<<< HEAD
=======

import com.example.liufan.xiangmu.duanzi.modle.ModelSF;
import com.example.liufan.xiangmu.duanzi.modle.Modle;


>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;
import com.example.liufan.xiangmu.fragment.CrosstalkFragment;

<<<<<<< HEAD



public class IPresenter {

    private DuanZiIView duanZiIView;
    private IModle modle;

=======
/**
 * Created by liufan on 2018/4/24.
 */
import retrofit2.http.HEAD;

public class IPresenter implements Presenter {

    private Modle modle;
    private DuanZiIView duanZiIView;
>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d
    public IPresenter(DuanZiIView duanZiIView) {
        this.duanZiIView = duanZiIView;
        modle = new IModle();
    }

<<<<<<< HEAD

    public void getDZdata(String url,int page){
        modle.getDZData(url, page);
        modle.setCallbackData(new IModle.CallbackData() {
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

=======
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
>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d

}

<<<<<<< HEAD

=======
>>>>>>> 78aa9213492c7aba2974828d9f07baede19bea5d
}
