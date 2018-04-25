package com.example.liufan.xiangmu.qita.modle;

import com.example.liufan.xiangmu.bean.LoginBean;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by liufan on 2018/4/25.
 */

public interface Modle1 {
    void okLoadError(String ss);
    void okLoadSuccess(LoginBean loginBean);
}
