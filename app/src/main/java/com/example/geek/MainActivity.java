package com.example.geek;


import android.widget.RadioGroup;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.geek.base.BaseActivity;

import com.example.geek.bean.BannerBean;
import com.example.geek.bean.Beanone;
import com.example.geek.bean.FirstBean;
import com.example.geek.fragment.AttentionFragment;
import com.example.geek.fragment.FicationFragment;
import com.example.geek.fragment.HomeFragment;
import com.example.geek.fragment.MyFragment;
import com.example.geek.peresenter.MainPeresenter;

import com.example.geek.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainView, MainPeresenter> implements MainView {

    @BindView(R.id.rag)
    RadioGroup rg;
    private FragmentManager mManager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;
    private int mLastFragmentPosition;

    @Override
    protected MainPeresenter initPeresenter() {
        return new MainPeresenter();
    }

    @Override
    protected void initView() {
        initEvent();
        mManager = getSupportFragmentManager();
        switchFragment(0);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void initEvent() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FicationFragment());
        fragments.add(new AttentionFragment());
        fragments.add(new MyFragment());

        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("分类");
        strings.add("关注");
        strings.add("我的");

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt1:
                        switchFragment(0);
                        break;
                    case R.id.bt2:
                        switchFragment(1);
                        break;
                    case R.id.bt3:
                        switchFragment(2);
                        break;
                    case R.id.bt4:
                        switchFragment(3);
                        break;
                }
            }
        });
    }


    private void switchFragment(int type) {
        //显示一个fragmnet,隐藏一个Fragment
        //显示
        Fragment fragment = fragments.get(type);
        //需要隐藏
        Fragment hideFragment = fragments.get(mLastFragmentPosition);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.frag, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        mLastFragmentPosition = type;
    }

    @Override
    public void showBanner(BannerBean bannerBean) {

    }

    @Override
    public void showFirst(FirstBean bean) {

    }

    @Override
    public void showFirsttest(Beanone beanone) {

    }
}
