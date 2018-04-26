package com.example.liufan.xiangmu.tuijain.presenter;

import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
import com.example.liufan.xiangmu.tuijain.modle.IModle;
import com.example.liufan.xiangmu.tuijain.modle.Modle;
import com.example.liufan.xiangmu.tuijain.View.ItuijianView;

/**
 * Created by liufan on 2018/4/24.
 */

public class Presenter {
    //轮播图
    public void  getlunbopresenter(final ItuijianView ituijianView){
        IModle IModle=new IModle ();
        IModle.getlunbo (new Modle () {
            @Override
            public void TuijianOnSuccess(LunBoBean LunBoBean) {
                if(ituijianView!=null){
                    ituijianView.TuijianOnSuccess (LunBoBean);
                }
            }

            @Override
            public void TuijianOnError(Throwable Throwable) {
                if(ituijianView!=null){
                    ituijianView.TuijianOnError (Throwable);
                }
            }
        });
    }
}
