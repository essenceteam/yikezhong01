package com.example.liufan.xiangmu.tuijain.View.Iview;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
public interface IView {
    void TuijianOnSuccess(LunBoBean LunBoBean);
    void TuijianOnError(Throwable Throwable);
}
