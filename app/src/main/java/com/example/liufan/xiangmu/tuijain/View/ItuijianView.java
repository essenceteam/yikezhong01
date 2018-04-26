package com.example.liufan.xiangmu.tuijain.View;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
/**
 *
 */
public interface ItuijianView {
    void TuijianOnSuccess(LunBoBean LunBoBean);
    void TuijianOnError(Throwable Throwable);
}
