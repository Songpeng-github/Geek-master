package com.example.geek.login.bean;

/**
 * name:&{宋佳羿}
 * date:2019/11/21
 * Time:13:41
 */
public class ResetJson {

    public ResetJson(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }

    /**
     * loginname :
     * password :
     */

    private String loginname;
    private String password;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ResetJson{" +
                "loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
