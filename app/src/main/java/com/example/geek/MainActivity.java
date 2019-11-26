package com.example.geek;


import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.geek.activity.AllActivity;
import com.example.geek.activity.AssetsActivity;
import com.example.geek.activity.CatActivity;
import com.example.geek.activity.HandActivity;
import com.example.geek.activity.JudicialActivity;

import com.example.geek.activity.PaiActivity;
import com.example.geek.activity.RealActivity;
import com.example.geek.activity.TreasureActivity;
import com.example.geek.base.BaseActivity;

import com.example.geek.bean.BannerBean;
import com.example.geek.bean.Beanone;
import com.example.geek.bean.FirstBean;
import com.example.geek.fragment.AttentionFragment;
import com.example.geek.fragment.FicationFragment;
import com.example.geek.fragment.HomeFragment;
import com.example.geek.fragment.MyFragment;
import com.example.geek.peresenter.MainPeresenter;
import com.example.geek.utils.IntentUtils;
import com.example.geek.utils.Logger;
import com.example.geek.view.MainView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainView, MainPeresenter> implements MainView {

    private static final String TAG = "MainActivity";

    @BindView(R.id.serachview)
    SearchView searchView;
    @BindView(R.id.re)
    RecyclerView recyclerView;
    @BindView(R.id.fenxiang)
    ImageView fx;
    @BindView(R.id.banner)
    Banner ban;

    @BindView(R.id.rag)
    RadioGroup rg;
    @BindView(R.id.bt1)
    RadioButton shouye;
    @BindView(R.id.bt2)
    RadioButton fenlei;
    @BindView(R.id.bt3)
    RadioButton guanzhu;
    @BindView(R.id.bt4)
    RadioButton wode;

    @BindView(R.id.sf)
    LinearLayout sf;
    @BindView(R.id.ershou)
    LinearLayout es;
    @BindView(R.id.fangchan)
    LinearLayout fc;
    @BindView(R.id.cat)
    LinearLayout cat;
    @BindView(R.id.zichan)
    LinearLayout zc;
    @BindView(R.id.zhenpin)
    LinearLayout zp;
    @BindView(R.id.pai)
    LinearLayout pai;
    @BindView(R.id.quanbu)
    LinearLayout qb;

    @BindView(R.id.im_sf)
    ImageView im_sf;
    @BindView(R.id.text_sf)
    TextView text_sf;
    @BindView(R.id.im_es)
    ImageView im_es;
    @BindView(R.id.text_es)
    TextView text_es;
    @BindView(R.id.im_fc)
    ImageView im_fc;
    @BindView(R.id.text_fc)
    TextView text_fc;
    @BindView(R.id.im_cat)
    ImageView im_cat;
    @BindView(R.id.text_cat)
    TextView text_cat;
    @BindView(R.id.im_zc)
    ImageView im_zc;
    @BindView(R.id.text_zc)
    TextView text_zc;
    @BindView(R.id.im_zp)
    ImageView im_zp;
    @BindView(R.id.text_zp)
    TextView text_zp;
    @BindView(R.id.im_pai)
    ImageView im_pai;
    @BindView(R.id.text_pai)
    TextView text_pai;
    @BindView(R.id.im_qb)
    ImageView im_qb;
    @BindView(R.id.text_qb)
    TextView text_qb;


    private boolean mIsShowing = false;

    private PopupWindow popupWindow;
    private WindowManager.LayoutParams params;

    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private String s;
    private String first;
    private List<FirstBean.DataBean> data = new ArrayList<>();
    private int mLastFragmentPosition;
    private FragmentManager mManager;


    @OnClick({R.id.sf, R.id.ershou, R.id.fangchan, R.id.cat, R.id.zichan, R.id.zhenpin, R.id.pai, R.id.quanbu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sf:
               IntentUtils.getInstence().intent(MainActivity.this, JudicialActivity.class);
                break;
            case R.id.ershou:
          IntentUtils.getInstence().intent(MainActivity.this, HandActivity.class);
                break;
            case R.id.fangchan:
              IntentUtils.getInstence().intent(MainActivity.this, RealActivity.class );
                break;
            case R.id.cat:
               IntentUtils.getInstence().intent(MainActivity.this, CatActivity.class );
                break;
            case R.id.zichan:
              IntentUtils.getInstence().intent(MainActivity.this, AssetsActivity.class );
                break;
            case R.id.zhenpin:
              IntentUtils.getInstence().intent(MainActivity.this, TreasureActivity.class);
                break;
            case R.id.pai:
                IntentUtils.getInstence().intent(MainActivity.this, PaiActivity.class);
                break;
            case R.id.quanbu:
                IntentUtils.getInstence().intent(MainActivity.this, AllActivity.class);
                break;
        }
    }

    @Override
    protected MainPeresenter initPeresenter() {
        return new MainPeresenter();
    }

    @Override
    protected void initView() {
        initEvent();
        mManager = getSupportFragmentManager();
        params = getWindow().getAttributes();
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        List<BannerBean.DataBean> data = bannerBean.getData();
        ban.setImages(data);
        ban.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.DataBean bean = (BannerBean.DataBean) path;
                Glide.with(MainActivity.this).load(bean.getBannerUrl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void showFirst(FirstBean bean) {
    }

    @Override
    public void showFirsttest(Beanone beanone) {
        Logger.logD(TAG, "Beanone=======" + beanone);


      /*  Glide.with(this).load(beanone.getImage()).into(im_sf);
        text_sf.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_es);
        text_es.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_fc);
        text_fc.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_cat);
        text_cat.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_zc);
        text_zc.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_zp);
        text_zp.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_pai);
        text_pai.setText(beanone.getName());

        Glide.with(this).load(beanone.getImage()).into(im_qb);
        text_qb.setText(beanone.getName());*/
    }

    @Override
    protected void initData() {
        mPresenter.Banner();
        mPresenter.First();
        mPresenter.firsttext();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    public void popup(View view) {
        if (popupWindow == null) {
            initPopup();
        }
        if (!mIsShowing) {
            params.alpha = 0.3f;
            getWindow().setAttributes(params);
            popupWindow.showAtLocation(findViewById(R.id.fenxiang), Gravity.BOTTOM, 0, 0);
            mIsShowing = true;
        }
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

    private void initPopup() {
        View pop = View.inflate(this, R.layout.popupwindow, null);
        popupWindow = new PopupWindow(pop, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mIsShowing = false;
    }


    public void dismiss(View view) {
        if (popupWindow != null && mIsShowing) {
            popupWindow.dismiss();
            mIsShowing = false;
            params.alpha = 1f;
            getWindow().setAttributes(params);
        }
    }

}
