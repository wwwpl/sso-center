package com.wf.wf.sso.response;

/**
 * Exception
 */
public class SsoException extends RuntimeException {
    private Integer code;
    private String msg;
    private Exception exception;

    public SsoException(ExceptionEmnu enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public SsoException(ExceptionEmnu enums, Exception e) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.exception = e;
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

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
