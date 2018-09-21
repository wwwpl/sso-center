package com.wf.wf.sso.response;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 15:29 2018/8/15
 */
public class SsoInfo<T> {

    public static final Integer SUCESS_CODE = 1000;
    public static final String SUCESS_MSG = "成功";

    private Integer code;
    private String message;
   /* private String url;
    private T data;*/

    public void sucess(){
        code = SUCESS_CODE;
        message = SUCESS_MSG;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   /* public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }*/
}
