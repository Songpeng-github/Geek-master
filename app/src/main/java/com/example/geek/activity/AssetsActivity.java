package com.example.geek.activity;

import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;

import com.example.geek.bean.Beantwo;
import com.example.geek.bean.TwoBean;

import com.example.geek.peresenter.TwoPeresenter;
import com.example.geek.utils.Logger;

import com.example.geek.view.TwoView;

import java.util.List;

import butterknife.BindView;

public class AssetsActivity extends BaseActivity<TwoView, TwoPeresenter> implements TwoView  {
    private static final String TAG = "AssetsActivity";
    private List<TwoBean.DataBean> data;

    // 资产 主页 Activity
    @BindView(R.id.jiaotong)
    TextView jiaotong;
    @BindView(R.id.tudi)
    TextView tudi;
    @BindView(R.id.jixie)
    TextView jixie;
    @BindView(R.id.wuxing)
    TextView wuxing;
    @BindView(R.id.nong)
    TextView nong;
    @BindView(R.id.gu)
    TextView gu;
    @BindView(R.id.zhai)
    TextView zhai;
    @BindView(R.id.qita)
    TextView qita;
    private Beantwo._$181Bean beantwo_$181;
    private String name;
    private List<Beantwo._$181Bean.ListBean> list;

    @Override
    protected TwoPeresenter initPeresenter() {
        return new TwoPeresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_assets;
    }



    @Override
    protected void initData() {
      mPresenter.Beantwo();


    }


    @Override
    public void showtwo(TwoBean twoBean) {
        Logger.logD(TAG,"TwoBean"+twoBean);

    }



    @Override
    public void showbeantwo(Beantwo beantwo) {
        Logger.logD(TAG,"Beantwo"+beantwo);
        List<Beantwo._$37Bean.ListBeanXXXX> list = beantwo.get_$37().getList();

    }
}
