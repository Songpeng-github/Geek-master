package com.example.geek.login.bean;

/**
 * name:宋佳羿
 * date:2019/11/27
 * Time:15:12
 */
public class QQBean {

    /**
     * code : 1
     * data : https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101810126&redirect_uri=https://www.quepai.cn/qqLogin&scope=get_user_info&state=426122
     * msg : success
     */

    private String code;
    private String data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
