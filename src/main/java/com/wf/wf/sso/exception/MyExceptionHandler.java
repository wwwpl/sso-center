package com.wf.wf.sso.exception;


import com.wf.wf.sso.response.SsoException;
import com.wf.wf.sso.response.SsoInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 15:15 2018/8/15
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = SsoException.class)
    @ResponseBody
    public SsoInfo<String> jsonErrorHandler(HttpServletRequest req, SsoException e) throws Exception {
        SsoInfo<String> r = new SsoInfo<String>();
        r.setMessage(e.getMsg());
        r.setCode(e.getCode());
        return r;
    }


}