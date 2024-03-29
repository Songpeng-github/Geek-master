package com.example.geek.login.model;

import android.util.Log;

import com.example.geek.base.BaseModel;
import com.example.geek.login.bean.CheckBean;
import com.example.geek.login.bean.ForgetBean;
import com.example.geek.network.ApiService;
import com.example.geek.network.BaseObserver;
import com.example.geek.network.HttpUtils;
import com.example.geek.network.ResultCallBack;
import com.example.geek.network.RxUtils;
import com.example.geek.utils.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:15:17
 */
public class ForgetModel  extends BaseModel {


    private static final String TAG = "ForgetModel";



    //验证码
    public void forget(String json, final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("Content-Type:application/json"), json);

        Observable<ForgetBean> forget = apiserver.getForget(body);
        forget.compose(RxUtils.<ForgetBean>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<ForgetBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ForgetBean bean) {
                        Logger.logD(TAG,"===========ForgetBean==============="+bean.toString());
                        callBack.onSuccess(bean);
                    }
                });

    }



    //校监验证码
    public void CheckLMsgCode(String json, final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("Content-Type:application/json"), json);

        Observable<CheckBean> check = apiserver.getCheck(body);
        check.compose(RxUtils.<CheckBean>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<CheckBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(CheckBean bean) {
                        Logger.logD(TAG,"===========CheckBean==============="+bean.toString());
                        callBack.onSuccess(bean);
                    }
                });
    }
}
