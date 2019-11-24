package com.example.geek.activity;

import android.content.Intent;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.BinderThread;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;
import com.example.geek.login.bean.CheckBean;
import com.example.geek.login.bean.CheckJson;
import com.example.geek.login.bean.ForgetBean;
import com.example.geek.login.bean.ForgetJson;
import com.example.geek.login.bean.RegisterBean;
import com.example.geek.login.peresenter.ForgetPeresenter;
import com.example.geek.login.peresenter.RegistredPeresener;
import com.example.geek.login.view.ForgetView;
import com.example.geek.login.view.RegistredView;
import com.example.geek.utils.ToastUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:15:08
 *
 *              注册 界面
 */
public class RegisteredActivity extends BaseActivity<ForgetView, ForgetPeresenter> implements ForgetView {

    private static final String TAG = "RegisteredActivity";
    @BindView(R.id.renext)
     ImageView renext;
    @BindView(R.id.check)
     CheckBox checkBox;
    @BindView(R.id.rephone)
     EditText  rephone;
 @BindView(R.id.btn_yzm)
    Button  btn_yzm;
@BindView(R.id.yzm)
EditText yzm;

    @Override
    protected ForgetPeresenter initPeresenter() {
        return new ForgetPeresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_registered;
    }

    @OnClick({R.id.renext,R.id.check,R.id.btn_yzm,R.id.yzm})
    public  void  onClick(View view){
         switch (view.getId()){
             case R.id.renext:
                 if(TextUtils.isEmpty(yzm.getText().toString())){
                     ToastUtil.showLong("验证码不能为空");
                 }else {
                     if (checkBox.isChecked()==true) {
                         Intent intent = new Intent(RegisteredActivity.this,StatusActivity.class);
                         intent.putExtra("phone",rephone.getText().toString());
                         startActivity(intent);
                     }else {
                         ToastUtil.showLong("您未同意注册协议");
                     }
                 }

                 break;
             case R.id.btn_yzm:
                 if(TextUtils.isEmpty(rephone.getText().toString())){
                     ToastUtil.showLong("手机号不可以为空");
                 }else {
                     String s = new Gson().toJson(new ForgetJson(rephone.getText().toString()));
                     mPresenter.getForgetModel(s,rephone.getText().toString());


                     String check = new Gson().toJson(new CheckJson(rephone.getText().toString(),1+"",yzm.getText().toString()));
                     mPresenter.getCheck(check);

                 }

                 break;
         }
    }


    @Override
    public void showForget(ForgetBean forgetBean) {
        Log.d(TAG, "showForget: "+forgetBean);
    }

    @Override
    public void showCheck(CheckBean checkBean) {
        Log.d(TAG, "check: "+checkBean);
    }
}
