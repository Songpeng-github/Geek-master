package com.example.geek.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;
import com.example.geek.base.BaseView;
import com.example.geek.login.bean.RegisterBean;
import com.example.geek.login.bean.RegisterJson;
import com.example.geek.login.peresenter.PersonalPeresenter;
import com.example.geek.login.peresenter.RegistredPeresener;
import com.example.geek.login.view.PersonalView;
import com.example.geek.login.view.RegistredView;
import com.example.geek.login.view.ResetView;
import com.example.geek.utils.IntentUtils;
import com.example.geek.utils.ToastUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:14:00
 * <p>
 * 注册  个人用户界面
 */

public class PersonalActivity extends BaseActivity<RegistredView, RegistredPeresener> implements RegistredView {

    @BindView(R.id.pnext)
    ImageView next;
    @BindView(R.id.p_name)
    TextView p_name;
    @BindView(R.id.p_password)
    TextView p_password;
    @BindView(R.id.p_confirmpassword)
    TextView p_confir;
    private String phonetwo;
    private RegisterBean rr;

    @Override
    protected RegistredPeresener initPeresenter() {
        return new RegistredPeresener();
    }

    @Override
    protected void initData() {
        phonetwo = getIntent().getStringExtra("phonetwo");
    }

    @Override
    public void showRegister(RegisterBean registerBean) {
        rr = registerBean;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }


    @OnClick(R.id.pnext)
    public void Click() {
        if (TextUtils.isEmpty(p_name.getText().toString()) || TextUtils.isEmpty(p_password.getText().toString()) || TextUtils.isEmpty(p_confir.getText().toString())) {
            ToastUtil.showLong("请填入详细的信息");
        } else {
            if (p_name.getText().toString().equals(p_confir.getText().toString())) {
                mPresenter.Registre2(p_name.getText().toString(), p_password.getText().toString(), p_confir.getText().toString(), new Gson().toJson(new RegisterJson(phonetwo, p_password.getText().toString(), 1, p_name.getText().toString(), "", "", "", "", "")));
                if (rr.getMsg().equals("success")) {
                    IntentUtils.getInstence().intent(this, SuccessActivity.class);
                }
            } else {
                ToastUtil.showLong("请输入密码不一致");
            }
        }


    }


}
