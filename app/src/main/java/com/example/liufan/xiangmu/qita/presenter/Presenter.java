package com.example.liufan.xiangmu.qita.presenter;

import com.example.liufan.xiangmu.activity.LoginActivity;
import com.example.liufan.xiangmu.qita.modle.IModle;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Presenter {
    //登录的方法
  void Login(IModle iModle,String mobile,String password ,LoginActivity loginActivity);
}
