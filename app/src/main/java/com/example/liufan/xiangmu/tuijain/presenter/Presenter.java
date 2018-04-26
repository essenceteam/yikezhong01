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
    public void  getlunbopresenter(final IView.ILunBoView ILunBoView){
        IModle IModle=new IModle ();
        IModle.getlunbo (new Modle.Ilunbo () {
            @Override
            public void TuijianOnSuccess(LunBoBean LunBoBean) {
                if(ILunBoView!=null){
                    ILunBoView.TuijianOnSuccess (LunBoBean);
                }
            }

            @Override
            public void TuijianOnError(Throwable Throwable) {
                if(ILunBoView!=null){
                    ILunBoView.TuijianOnError (Throwable);
                }
            }
        });
    }
}
