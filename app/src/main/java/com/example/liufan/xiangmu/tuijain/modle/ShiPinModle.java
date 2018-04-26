package com.example.liufan.xiangmu.tuijain.modle;

import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface ShiPinModle {
    void  TuijianShiPinOnSuccess(TuijianshipinBean TuijianshipinBean);
    void  TuijianShiPinOnError(Throwable Throwable);

}
