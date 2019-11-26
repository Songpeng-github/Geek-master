package com.example.geek.fragment;

import androidx.fragment.app.Fragment;

import com.example.geek.R;
import com.example.geek.base.BaseFragment;
import com.example.geek.peresenter.HomePeresenter;
import com.example.geek.peresenter.MyPeresenter;
import com.example.geek.view.HomeView;
import com.example.geek.view.MyView;

/**
 * name:&{宋佳羿}
 * date:2019/11/21
 * Time:15:18
 */
public class MyFragment extends BaseFragment<MyView, MyPeresenter> implements  MyView {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected MyPeresenter initPeresenter() {
        return new MyPeresenter();
    }
}
