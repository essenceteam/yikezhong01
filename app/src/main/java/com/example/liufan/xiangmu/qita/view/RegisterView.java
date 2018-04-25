package com.example.liufan.xiangmu.qita.view;


import com.example.liufan.xiangmu.bean.RegisterBean;

/**
 * Created by liufan on 2018/4/25.
 */

public interface RegisterView {
    void RegisterError(String ss);
    void RegisterSuccess(RegisterBean registerBean);
}
