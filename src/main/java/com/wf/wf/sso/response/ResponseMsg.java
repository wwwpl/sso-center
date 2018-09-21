package com.wf.wf.sso.response;


/**
 * Created with IntelliJ IDEA.
 * Creator : wangfei212
 * Date : 2018年8月19日14:35:04
 */
public class ResponseMsg {

    public static final String SUCESS_CODE = "1000";
    public static final String SUCESS_MSG = "成功";

    private String code;
    private String msg;

    public void sucess(){
        code = SUCESS_CODE;
        msg = SUCESS_MSG;
    }

    public ResponseMsg() {
    }

    public ResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public void setCodeAndMsg(ExceptionEmnu enums){
        this.code = String.valueOf(enums.getCode());
        this.msg = String.valueOf(enums.getMsg());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
