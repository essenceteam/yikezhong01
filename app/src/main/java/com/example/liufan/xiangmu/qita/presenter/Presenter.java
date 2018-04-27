package com.example.liufan.xiangmu.qita.presenter;

import com.example.liufan.xiangmu.activity.PublishanarticleActivity;
import com.example.liufan.xiangmu.activity.QiTaActivity;
import com.example.liufan.xiangmu.activity.RegisterActivity;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.modle.Modle3;

import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Presenter {
    //登录的方法
  void Login(IModle iModle, String mobile, String password , QiTaActivity qiTaActivity);
  //注册的方法
  void Register(IModle iModle, String mobile, String password , RegisterActivity registerActivity);
  //发表的方法
  void Publishanarticle(IModle iModle,String url, String uid, String content, String token, List<MultipartBody.Part> file, PublishanarticleActivity publishanarticleActivity);
}
