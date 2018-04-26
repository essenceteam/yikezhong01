package com.example.liufan.xiangmu.tuijain.view.Iview;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
/**
 *
 */
public interface ItuijianView {
    void TuijianOnSuccess(LunBoBean LunBoBean);
    void TuijianOnError(Throwable Throwable);
}
