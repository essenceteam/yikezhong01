package com.example.liufan.xiangmu.tuijain.presenter;

import com.example.liufan.xiangmu.tuijain.View.IGuanzhuView;
import com.example.liufan.xiangmu.tuijain.View.IShiPinView;
import com.example.liufan.xiangmu.tuijain.modle.Bean.LunBoBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianguanzhuBean;
import com.example.liufan.xiangmu.tuijain.modle.Bean.TuijianshipinBean;
import com.example.liufan.xiangmu.tuijain.modle.GuanzhuModle;
import com.example.liufan.xiangmu.tuijain.modle.IModle;
import com.example.liufan.xiangmu.tuijain.modle.Modle;
import com.example.liufan.xiangmu.tuijain.View.ItuijianView;
import com.example.liufan.xiangmu.tuijain.modle.ShiPinModle;

/**
 * Created by liufan on 2018/4/24.
 */

public class Presenter {
    IModle IModle=new IModle ();
    //轮播图
    public void  getlunbopresenter(final ItuijianView ituijianView){

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
    //视频
    public void getvrdiopresenter(String android , int page,String ty, final IShiPinView IShiPinView){
        IModle.getvidio (android, page,ty, new ShiPinModle () {
            @Override
            public void TuijianShiPinOnSuccess(TuijianshipinBean TuijianshipinBean) {
                if(IShiPinView!=null){
                    IShiPinView.TuijianShiPinOnSuccess (TuijianshipinBean);
                }
            }

            @Override
            public void TuijianShiPinOnError(Throwable Throwable) {
                if(IShiPinView!=null){
                    IShiPinView.TuijianShiPinOnError (Throwable);
                }
            }
        });

    }
    //关注视频
    public void getvrdiopresenter1(String android , int page,String ty,String uid, final IGuanzhuView IGuanzhuView){
        IModle.getvidio1 (android, page, ty, uid, new GuanzhuModle () {
            @Override
            public void TuijianShiPinOnSuccess(TuijianguanzhuBean TuijianguanzhuBean) {
                if(IGuanzhuView!=null){
                    IGuanzhuView.TuijianShiPinOnSuccess (TuijianguanzhuBean);
                }
            }

            @Override
            public void TuijianShiPinOnError(Throwable Throwable) {
                if(IGuanzhuView!=null){
                    IGuanzhuView.TuijianShiPinOnError (Throwable);
                }
            }
        });

    }
}
