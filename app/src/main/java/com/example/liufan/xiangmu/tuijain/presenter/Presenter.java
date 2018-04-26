package com.example.liufan.xiangmu.tuijain.presenter;
import com.example.liufan.xiangmu.tuijain.View.IView.IView;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
import com.example.liufan.xiangmu.tuijain.modle.IModle;
import com.example.liufan.xiangmu.tuijain.modle.Modle;

/**
 * Created by liufan on 2018/4/24.
 */

public class Presenter {
    //轮播图
    public void  getlunbopresenter(final IView IView){
        IModle IModle=new IModle ();
        IModle.getlunbo (new Modle () {
            @Override
            public void TuijianOnSuccess(LunBoBean LunBoBean) {
                if(IView!=null){
                    IView.TuijianOnSuccess (LunBoBean);
                }
            }

            @Override
            public void TuijianOnError(Throwable Throwable) {
                if(IView!=null){
                    IView.TuijianOnError (Throwable);
                }
            }
        });
    }
}
