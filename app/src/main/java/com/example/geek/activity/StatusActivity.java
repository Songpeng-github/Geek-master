package com.example.geek.activity;


import android.content.Intent;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;
import com.example.geek.base.BaseView;
import com.example.geek.login.peresenter.StatusPeresenter;
import com.example.geek.login.view.StatusView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * name:&{宋佳羿}
 * date:2019/11/19
 * Time:14:19
 * <p>
 * 注册  选择身份界面
 */


public class StatusActivity extends BaseActivity<StatusView, StatusPeresenter> implements BaseView {
    @BindView(R.id.city)
    ImageView city;
    @BindView(R.id.people)
    ImageView people;
    private String phone;


    @Override
    protected StatusPeresenter initPeresenter() {
        return new StatusPeresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_status;
    }

    @Override
    protected void initData() {
        phone = getIntent().getStringExtra("phone");
    }

    @OnClick({R.id.city, R.id.people})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.city:
                Intent intent = new Intent(StatusActivity.this, EnterpriseActivity.class);
                intent.putExtra("phoneone", phone);
                startActivity(intent);
                break;
            case R.id.people:
                Intent intenttwo = new Intent(StatusActivity.this, PersonalActivity.class);
                intenttwo.putExtra("phonetwo", phone);
                startActivity(intenttwo);
                break;
        }
    }
}
