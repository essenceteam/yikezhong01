package com.example.liufan.xiangmu.duanzi.view;

import com.example.liufan.xiangmu.duanzi.bean.DZListBean;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public interface DuanZiIView {
    void dzOnSuccess(DZListBean dzListBean);
    void dzOnFail(String e);
}
