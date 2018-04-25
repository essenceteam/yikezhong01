package com.example.liufan.xiangmu.activity;

import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.LoginBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.presenter.IPresenter;
import com.example.liufan.xiangmu.qita.view.LoginView;

/**
 * Created by liufan on 2018/4/25.
 */

public class LoginActivity extends BaesActivity implements LoginView{
    @Override
    public int getlayout() {
        return 0;
    }

    @Override
    public void getinit() {

    }

    @Override
    public void getdata() {
        IPresenter iPresenter = new IPresenter();
        //iPresenter.Login(new IModle(),,,this);
    }

    @Override
    public void ViewLoadError(String ss) {

    }

    @Override
    public void ViewLoadSuccess(LoginBean loginBean) {

    }
}
