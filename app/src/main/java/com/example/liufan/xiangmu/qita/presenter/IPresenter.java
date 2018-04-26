package com.example.liufan.xiangmu.qita.presenter;

import com.example.liufan.xiangmu.activity.QiTaActivity;
import com.example.liufan.xiangmu.activity.RegisterActivity;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.modle.Modle1;
import com.example.liufan.xiangmu.qita.modle.Modle2;

/**
 * Created by liufan on 2018/4/24.
 */

public class IPresenter implements Presenter {
    //登录的方法
    @Override
    public void Login(IModle iModle, String mobile, String password, final QiTaActivity qiTaActivity) {
        iModle.Login(API.Url, mobile, password, new Modle1() {
            @Override
            public void okLoadError(String ss) {
                qiTaActivity.ViewLoadError(ss);
            }

            @Override
            public void okLoadSuccess(Object object) {
                LoginBean loginBean = (LoginBean) object;
                qiTaActivity.ViewLoadSuccess(loginBean);
            }

    });
    }
    //注册的方法
    @Override
    public void Register(IModle iModle, String mobile, String password, final RegisterActivity registerActivity) {
        iModle.Register(API.Url, mobile, password, new Modle2() {
            @Override
            public void okLoadError(String ss) {
                registerActivity.RegisterError(ss);
            }

            @Override
            public void okLoadSuccess(Object object) {
                registerActivity.RegisterSuccess((RegisterBean) object);

            }
        });
    }
}
