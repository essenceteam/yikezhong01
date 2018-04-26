package com.example.liufan.xiangmu.tuijain.modle;

import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Modle {
        void TuijianOnSuccess(LunBoBean LunBoBean);
        void TuijianOnError(Throwable Throwable);


}
