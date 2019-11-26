package com.example.geek.model;

import com.example.geek.base.BaseModel;
import com.example.geek.bean.Beantwo;
import com.example.geek.bean.TwoBean;
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
 * date:2019/11/26
 * Time:&{TIME}
 */
public class TwoModel extends BaseModel {
    private static final String TAG = "TwoModel";

    public void two(String code, final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        Observable<TwoBean> banner = apiserver.getTwo();
        banner.compose(RxUtils.<TwoBean>rxObserableSchedulerHelper())//切换线程
                .subscribe(new BaseObserver<TwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(TwoBean bean) {
                        Logger.logD(TAG, "===========TwoBean===============" + bean.toString());
                        callBack.onSuccess(bean);
                    }
                });
    }




    public void Beantwo(final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        Observable<Beantwo> banner = apiserver.getBeantwo();
        banner.compose(RxUtils.<Beantwo>rxObserableSchedulerHelper())//切换线程
                .subscribe(new BaseObserver<Beantwo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Beantwo bean) {
                        Logger.logD(TAG, "===========Beantwo===============" + bean.toString());
                        callBack.onSuccess(bean);
                    }
                });
    }
}
