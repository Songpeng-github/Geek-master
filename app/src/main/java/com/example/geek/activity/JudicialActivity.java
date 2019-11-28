package com.example.geek.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geek.R;
import com.example.geek.base.BaseActivity;
import com.example.geek.peresenter.JudicPeresenter;
import com.example.geek.view.JudicView;

import butterknife.BindView;
import butterknife.OnClick;


public class JudicialActivity extends BaseActivity<JudicView, JudicPeresenter> implements JudicView {
    //司法拍卖    主页Activity

    @BindView(R.id.judic_paixun)
    TextView judic_paixun;
    @BindView(R.id.judic_fenlei)
    LinearLayout judic_fenlei;
    @BindView(R.id.judic_di)
    LinearLayout judic_di;
    @BindView(R.id.judic_zhuangtai)
    LinearLayout judic_zhuangtai;





    @Override
    protected JudicPeresenter initPeresenter() {
        return new JudicPeresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_judicial;
    }


    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.judic_paixun, R.id.judic_fenlei, R.id.judic_di, R.id.judic_zhuangtai})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.judic_paixun:
              judic_paixun.setTextColor(R.color.grey);
                break;
        }
    }

    @Override
    protected void initView() {
        final SpannableStringBuilder style = new SpannableStringBuilder();
        style.append("如果你真的喜欢我，请疯狂的点击我把");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(JudicialActivity.this, "触发点击事件!", Toast.LENGTH_SHORT).show();
            }
        };
        style.setSpan(clickableSpan, 10, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        judic_paixun.setText(style);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0000FF"));
        style.setSpan(foregroundColorSpan, 10, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        judic_paixun.setMovementMethod(LinkMovementMethod.getInstance());
        judic_paixun.setText(style);

    }
}
