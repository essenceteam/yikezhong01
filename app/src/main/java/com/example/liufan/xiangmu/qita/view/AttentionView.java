package com.example.liufan.xiangmu.qita.view;


import com.example.liufan.xiangmu.bean.AttentionBean;
import com.example.liufan.xiangmu.bean.RegisterBean;

/**
 * Created by liufan on 2018/4/25.
 */

public interface AttentionView {
    void AttentionError(String ss);
    void AttentionSuccess(AttentionBean attentionBean);
}
