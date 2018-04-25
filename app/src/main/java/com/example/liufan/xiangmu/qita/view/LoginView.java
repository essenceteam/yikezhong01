package com.example.liufan.xiangmu.qita.view;

import com.example.liufan.xiangmu.bean.LoginBean;

/**
 * Created by liufan on 2018/4/25.
 */

public interface LoginView {
    void ViewLoadError(String ss);
    void ViewLoadSuccess(LoginBean loginBean);
}
