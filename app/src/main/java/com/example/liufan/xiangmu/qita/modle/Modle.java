package com.example.liufan.xiangmu.qita.modle;

import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Modle {
    //登录的方法
    void Login(String url,String mobile,String password,Modle1 modle1);
    //注册的方法
    void Register(String url,String mobile,String password,Modle2 modle2);
    //发布段子
    void Publishanarticle(String url, String uid, String content, String token, List<MultipartBody.Part> file, Modle3 modle3);
   //我的关注
    void Myattention(String url, String uid, String token,Modle4 modle4);
}
