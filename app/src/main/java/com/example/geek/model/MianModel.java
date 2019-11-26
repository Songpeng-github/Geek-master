package com.example.geek.model;

import com.example.geek.base.BaseModel;
import com.example.geek.bean.BannerBean;
import com.example.geek.bean.Beanone;
import com.example.geek.bean.FirstBean;
import com.example.geek.network.ApiService;
import com.example.geek.network.BaseObserver;
import com.example.geek.network.HttpUtils;
import com.example.geek.network.ResultCallBack;
import com.example.geek.network.RxUtils;
import com.example.geek.utils.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:18:23
 */
public class MianModel extends BaseModel {
    private static final String TAG = "MianModel";

    public void banner(final ResultCallBack callBack) {


        //轮播图
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        //  RequestBody body = RequestBody.create(MediaType.parse("Content-Type:application/json"), json);

        Observable<BannerBean> banner = apiserver.HomeBanner();
        banner.compose(RxUtils.<BannerBean>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(BannerBean bean) {
                        Logger.logD(TAG, "===========MianModel===============" + bean.toString());
                        callBack.onSuccess(bean);
                    }
                });

    }

 //  一级范围  正式接口
    public void First(final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        // RequestBody body = RequestBody.create(MediaType.parse("Content-Type:application/json"), json);

        Observable<FirstBean> first = apiserver.getFirst();
        first.compose(RxUtils.<FirstBean>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<FirstBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(FirstBean bean) {
                        Logger.logD(TAG, "===========FirstBean===============" + bean.toString());
                        callBack.onSuccess(bean);
                    }
                });

    }

//一级范围 测试接口
    public void firsttext(final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);

        Observable<Beanone> banner = apiserver.getfirsttext();
        banner.compose(RxUtils.<Beanone>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<Beanone>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Beanone bean) {
                        Logger.logD(TAG, "===========Beanone===============" + bean.toString());
                        callBack.onSuccess(bean);
                    }
                });
    }
}