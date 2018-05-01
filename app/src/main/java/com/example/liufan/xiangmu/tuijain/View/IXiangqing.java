package com.example.liufan.xiangmu.tuijain.View;

import com.example.liufan.xiangmu.tuijain.modle.Bean.Tuijianyonghu_Xiangqing_bean;

/**
 * Created by lenovo on 2018/4/28.
 */

public interface IXiangqing {
    void Tuijian_xiangqing_OnSuccess(Tuijianyonghu_Xiangqing_bean Tuijianyonghu_Xiangqing_bean);
    void Tuijian_xiangqing_OnError(Throwable Throwable);
}
