package com.example.geek.login.model;

import android.util.Log;

import com.example.geek.base.BaseModel;
import com.example.geek.login.bean.LoginBean;
import com.example.geek.login.bean.RegisterBean;
import com.example.geek.network.ApiService;
import com.example.geek.network.BaseObserver;
import com.example.geek.network.HttpUtils;
import com.example.geek.network.ResultCallBack;
import com.example.geek.network.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:15:15
 */
public class RegistredModel extends BaseModel {

    private static final String TAG = "RegistredModel";
    public void Registred(String json,final ResultCallBack callBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        RequestBody body = RequestBody.create(MediaType.parse("Content-Type:application/json"), json);

        Observable<RegisterBean> register = apiserver.getRegister(body);

        register.compose(RxUtils.<RegisterBean>rxObserableSchedulerHelper())//切换线程

                .subscribe(new BaseObserver<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RegisterBean bean) {
                        Log.d(TAG, "onNext: "+bean.toString());
                        callBack.onSuccess(bean);
                    }
                });
    }

}
