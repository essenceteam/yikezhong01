package com.example.liufan.xiangmu.qita.presenter;

import com.example.liufan.xiangmu.activity.LoginActivity;
import com.example.liufan.xiangmu.activity.QiTaActivity;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.modle.Modle1;

/**
 * Created by liufan on 2018/4/24.
 */

public class IPresenter implements Presenter{
    @Override
    public void Login(IModle iModle, String mobile, String password, final QiTaActivity qiTaActivity) {
        iModle.Login(API.Url, mobile, password, new Modle1() {
            @Override
            public void okLoadError(String ss) {
                qiTaActivity.ViewLoadError(ss);
            }

            @Override
<<<<<<< HEAD
            public void okLoadSuccess(LoginBean loginBean) {
                qiTaActivity.ViewLoadSuccess(loginBean);
=======
            public void okLoadSuccess(Object object) {
                LoginBean loginBean = (LoginBean) object;
                loginActivity.ViewLoadSuccess(loginBean);
>>>>>>> c926d1313329ba63c4040982b6396317aec6d5a9
            }
        });
    }
}
