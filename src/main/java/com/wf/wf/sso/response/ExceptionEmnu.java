package com.wf.wf.sso.response;

/**
 * Created by gaoye1 on 2016/8/24.
 */
public enum ExceptionEmnu {


    SUCCESS(1000, "成功");


    private Integer code;
    private String msg;

    ExceptionEmnu(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
