package com.example.geek.login.peresenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.geek.base.BasePeresenter;

import com.example.geek.login.bean.CheckBean;
import com.example.geek.login.bean.ForgetBean;
import com.example.geek.login.model.ForgetModel;
import com.example.geek.login.view.ForgetView;
import com.example.geek.network.ResultCallBack;
import com.example.geek.utils.ToastUtil;

/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:15:17
 */
public class ForgetPeresenter extends BasePeresenter<ForgetView> implements ResultCallBack {
    private static final String TAG = "ForgetPeresenter";


    ForgetModel forgetModel= new ForgetModel();
    public void getForgetModel(String json,String phone) {

           forgetModel.forget(json,this);

       }

       public  void  getCheck(String json){
        forgetModel.CheckLMsgCode(json, new ResultCallBack() {
            @Override
            public void onSuccess(Object bean) {
                view.showCheck((CheckBean) bean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
       }


    @Override
    protected void initModel() {
        forgetModel = new ForgetModel();
        models.add(forgetModel);
    }

    @Override
    public void onSuccess(Object bean) {
      view.showForget((ForgetBean) bean);
    }

    @Override
    public void onFail(String msg) {
        Log.d(TAG, "onFail: "+msg);
    }
}
