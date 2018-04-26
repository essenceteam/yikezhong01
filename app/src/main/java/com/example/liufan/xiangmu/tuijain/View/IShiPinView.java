package com.example.liufan.xiangmu.tuijain.View;

import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface IShiPinView {
    void  TuijianShiPinOnSuccess(TuijianshipinBean TuijianshipinBean);
    void  TuijianShiPinOnError(Throwable Throwable);
}
