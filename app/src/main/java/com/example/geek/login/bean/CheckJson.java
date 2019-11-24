package com.example.geek.login.bean;

/**
 * name:&{宋佳羿}
 * date:2019/11/22
 * Time:17:54
 */
public class CheckJson {
    public CheckJson(String loginname, String checkMobile, String msgCode) {
        this.loginname = loginname;
        this.checkMobile = checkMobile;
        this.msgCode = msgCode;
    }

    /**
     * loginname :
     * checkMobile :
     * msgCode :
     */

    private String loginname;
    private String checkMobile;
    private String msgCode;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getCheckMobile() {
        return checkMobile;
    }

    public void setCheckMobile(String checkMobile) {
        this.checkMobile = checkMobile;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }
}
