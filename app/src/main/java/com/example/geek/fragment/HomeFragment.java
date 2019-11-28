package com.example.geek.fragment;

import android.content.Context;
import android.content.res.Resources;

import android.util.TypedValue;

import android.view.Gravity;
import android.view.View;

import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import android.widget.TextView;

import androidx.appcompat.widget.SearchView;


import com.bumptech.glide.Glide;
import com.example.geek.MainActivity;
import com.example.geek.R;
import com.example.geek.activity.AllActivity;
import com.example.geek.activity.AssetsActivity;
import com.example.geek.activity.CatActivity;
import com.example.geek.activity.HandActivity;
import com.example.geek.activity.JudicialActivity;
import com.example.geek.activity.PaiActivity;
import com.example.geek.activity.RealActivity;
import com.example.geek.activity.TreasureActivity;
import com.example.geek.base.BaseFragment;
import com.example.geek.bean.BannerBean;
import com.example.geek.bean.Beanone;
import com.example.geek.bean.FirstBean;
import com.example.geek.main.TakePhotoPopWin;
import com.example.geek.peresenter.HomePeresenter;
import com.example.geek.peresenter.MainPeresenter;
import com.example.geek.utils.IntentUtils;
import com.example.geek.utils.Logger;
import com.example.geek.view.HomeView;
import com.example.geek.view.MainView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * name:&{宋佳羿}
 * date:2019/11/21
 * Time:15:15
 */
public class HomeFragment  extends BaseFragment<MainView, MainPeresenter> implements MainView {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
    private static final String TAG = "MainActivity";
    @BindView(R.id.home_search)
    SearchView searchView;
    @BindView(R.id.fenxiang)
    ImageView fx;
    @BindView(R.id.banner)
    Banner ban;



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


    @OnClick({R.id.sf, R.id.ershou, R.id.fangchan, R.id.cat, R.id.zichan, R.id.zhenpin, R.id.pai, R.id.quanbu, R.id.fenxiang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sf:
                IntentUtils.getInstence().intent(getContext(), JudicialActivity.class);
                break;
            case R.id.ershou:
                IntentUtils.getInstence().intent(getContext(), HandActivity.class);
                break;
            case R.id.fangchan:
                IntentUtils.getInstence().intent(getContext(), RealActivity.class);
                break;
            case R.id.cat:
                IntentUtils.getInstence().intent(getContext(), CatActivity.class);
                break;
            case R.id.zichan:
                IntentUtils.getInstence().intent(getContext(), AssetsActivity.class);
                break;
            case R.id.zhenpin:
                IntentUtils.getInstence().intent(getContext(), TreasureActivity.class);
                break;
            case R.id.pai:
                IntentUtils.getInstence().intent(getContext(), PaiActivity.class);
                break;
            case R.id.quanbu:
                IntentUtils.getInstence().intent(getContext(), AllActivity.class);
                break;
            case R.id.fenxiang:
                showPopwindow();
                break;
            case R.id.home_search:
                initSearch();
                break;
        }
    }

    private void initSearch() {
        // 设置搜索文本监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            //当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void showPopwindow() {
        TakePhotoPopWin takePhotoPopWin = new TakePhotoPopWin(getContext(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        takePhotoPopWin.showAtLocation(fx, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, -1, -1);
    }

    @Override
    protected MainPeresenter initPeresenter() {
        return new MainPeresenter();
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        List<BannerBean.DataBean> data = bannerBean.getData();
        ban.setImages(data);
        ban.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.DataBean bean = (BannerBean.DataBean) path;
                Glide.with(getContext()).load(bean.getBannerUrl()).into(imageView);
            }
        }).start();
    }
    @Override
    public void showFirst(FirstBean bean) {

    }
    @Override
    public void showFirsttest(Beanone beanone) {
        Logger.logD(TAG, "Beanone=======" + beanone);
    }
    @Override
    protected void initData() {
        mPresenter.Banner();
        mPresenter.First();
        mPresenter.firsttext();
    }
}
