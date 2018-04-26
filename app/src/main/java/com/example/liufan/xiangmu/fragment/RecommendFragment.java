package com.example.liufan.xiangmu.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.adapter.ViewPagerAdapter;
import com.example.liufan.xiangmu.tuijain.View.GuanZhu_Fragment;
import com.example.liufan.xiangmu.tuijain.View.Remen_Fragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liufan on 2018/4/24.
 */

public class RecommendFragment extends Fragment {

    Unbinder unbinder;
    List<String> list = new ArrayList<> ();
    List<Fragment> listFrag = new ArrayList<> ();
    @BindView(R.id.tuijian_tab)
    TabLayout tuijianTab;
    @BindView(R.id.tuijian_vp)
    ViewPager tuijianVp;
    private View view;
    private ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate (R.layout.recommenfragmentlayout, container, false);
        unbinder = ButterKnife.bind (this, view);
        //tab字
        list.add ("热门");
        list.add ("关注");
        //实例Fragment
        Remen_Fragment Remen_Fragment=new Remen_Fragment ();
        GuanZhu_Fragment GuanZhu_Fragment=new GuanZhu_Fragment ();
        //
        listFrag.add (Remen_Fragment);
        listFrag.add (GuanZhu_Fragment);
        //添加viewpagr适配器
        viewPagerAdapter = new ViewPagerAdapter (getActivity (), list, getActivity ().getSupportFragmentManager (), listFrag);
        tuijianVp.setAdapter (viewPagerAdapter);
        // tablayout.addTab可以将标题添加进Tab里面，true表示默认选中
        tuijianTab.addTab(tuijianTab.newTab().setText(list.get(0)), true);
        tuijianTab.addTab(tuijianTab.newTab().setText(list.get(1)), false);
        //这两个方法是将Tablayout和Viewpager联合起来
        tuijianTab.setupWithViewPager(tuijianVp);
        tuijianTab.setTabsFromPagerAdapter(viewPagerAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }
}
