package com.example.liufan.xiangmu.qita.modle;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Modle {
    //登录的方法
    void Login(String url,String mobile,String password,Modle1 modle1);
    //注册的方法
    void Register(String url,String mobile,String password,Modle2 modle2);

}
