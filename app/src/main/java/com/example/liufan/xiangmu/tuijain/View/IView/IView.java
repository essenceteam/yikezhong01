package com.example.liufan.xiangmu.tuijain.View.IView;

import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;

/**
 * Created by liufan on 2018/4/24.
 */

public class  IView {
    public interface  ILunBoView{
        void TuijianOnSuccess(LunBoBean LunBoBean);
        void TuijianOnError(Throwable Throwable);
    }

}
