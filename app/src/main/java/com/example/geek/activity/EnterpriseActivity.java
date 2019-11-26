package com.example.geek.activity;


import android.content.Intent;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;
import com.example.geek.login.bean.RegisterBean;
import com.example.geek.login.bean.RegisterJson;
import com.example.geek.login.peresenter.RegistredPeresener;
import com.example.geek.login.view.RegistredView;
import com.example.geek.utils.IntentUtils;
import com.example.geek.utils.ToastUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:14:56
 * <p>
 * 注册 企业界面
 */

public class EnterpriseActivity extends BaseActivity<RegistredView, RegistredPeresener> implements RegistredView {

    private static final String TAG = "EnterpriseActivity";
    @BindView(R.id.enext)
    ImageView enext;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.enterprise)
    EditText enterprise;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirmpassword)
    EditText confirmpassword;
    private RegisterBean re = new RegisterBean();
    private String phone;

    @Override
    protected RegistredPeresener initPeresenter() {
        return new RegistredPeresener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enterprise;
    }

    @Override
    protected void initData() {
        phone = getIntent().getStringExtra("phoneone");
        Log.d(TAG, "initData: " + phone);
    }

    @OnClick(R.id.enext)
    public void onClick() {
//isEmpty 为空
// equals 相等
        if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(confirmpassword.getText().toString()) || TextUtils.isEmpty(enterprise.getText().toString())) {
            ToastUtil.showLong("请填入详细信息");
        } else {
            if (password.getText().toString().equals(confirmpassword.getText().toString())) {
                mPresenter.Registre(name.getText().toString(), enterprise.getText().toString(), password.getText().toString(), confirmpassword.getText().toString(),
                        new Gson().toJson(new RegisterJson(phone, password.getText().toString(), 2, name.getText().toString(), "", enterprise.getText().toString(), "", "", "")));

                if (re.getMsg().equals("success")) {
                    IntentUtils.getInstence().intent(EnterpriseActivity.this, SuccessActivity.class);
                } else {
                    ToastUtil.showLong("账号已存在");
                }
            } else {
                ToastUtil.showLong("输入的密码不一致");
            }
        }
    }

    @Override
    public void showRegister(RegisterBean registerBean) {
        Log.d(TAG, "showRegister: " + registerBean.toString());
        re = registerBean;
    }
}
