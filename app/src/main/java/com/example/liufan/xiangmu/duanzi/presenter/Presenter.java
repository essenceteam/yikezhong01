package com.example.liufan.xiangmu.duanzi.presenter;
import com.example.liufan.xiangmu.duanzi.view.DuanZiIView;
import com.example.liufan.xiangmu.fragment.CrosstalkFragment;

/**
 * Created by liufan on 2018/4/24.
 */

public interface Presenter {

    void getDZData(String url, String version, int page, CrosstalkFragment crosstalkFragment);

}
