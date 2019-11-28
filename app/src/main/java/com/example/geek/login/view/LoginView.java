package com.example.geek.login.view;

import com.example.geek.base.BaseView;
import com.example.geek.login.bean.LoginBean;
import com.example.geek.login.bean.QQBean;

/**
 * name:&{宋佳羿}
 * date:2019/11/18
 * Time:18:14
 */
public interface LoginView extends BaseView {


   void showLoginbean(LoginBean msg);

   void  showQQ(QQBean bean);

}
