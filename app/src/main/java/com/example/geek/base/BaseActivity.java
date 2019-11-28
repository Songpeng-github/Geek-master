package com.example.geek.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
/*
  MVP
  V:处理视图    用户交互
  M: 数据操作  如：网络请求 数据库
  P:业务处理   连接 V层与M层
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePeresenter> extends AppCompatActivity implements BaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        StatusBarUtil.setTranslucentStatus(this);
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this,0x55000000);
        }*/

        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter =initPeresenter();
        if(mPresenter!=null){
          mPresenter.bind((V) this);
        }
          initView();
          initData();
          initListen();
    }

    protected abstract P initPeresenter();

    protected abstract int getLayoutId();

    protected void initView() {
    }

    ;

    protected void initData() {
    }

    ;

    protected void initListen() {
    }

    ;
}
