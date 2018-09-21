package com.wf.wf.sso.controller;

import com.google.common.base.Preconditions;
import com.wf.wf.sso.response.ResponseMsg;
import com.wf.wf.sso.util.JsonUtil;
import com.wf.wf.sso.util.MockDatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author wangfei
 * @date 2018/9/20 12:43
 */
@Slf4j
@Controller
public class SsoController {

    @RequestMapping("/api/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> map,HttpSession session){
        log.info(session.getId());
        log.info("login:{}",session.getAttribute("token"));
        Preconditions.checkNotNull(map.get("email"),"email不能为空");
        Preconditions.checkNotNull(map.get("password"),"password不能为空");
        if ("673391104@qq.com".equals(map.get("email"))&&"123".equals(map.get("password"))){
            //1.创建令牌信息,只要保证唯一即可,我们就使用UUID.
            String token = UUID.randomUUID().toString();
            //2.创建全局的会话,把令牌信息放入会话中.
            //3.需要把令牌信息放到数据库中.
            session.setAttribute("token","111111111");
//            MockDatabaseUtil.T_TOKEN.add(token);
            //4.重定向到redirectUrl,把令牌信息带上.  http://www.crm.com:8088/main?token=
            log.info("redirectUrl:{}",map.get("redirectUrl"));
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.setCode("1000");
            responseMsg.setMsg(map.get("redirectUrl"));
            return JsonUtil.toJsonStr(responseMsg);
        }
        log.info("email1:{}",map.get("email"));
        //如果账号密码有误,重新回到登录页面,还需要把redirectUrl放入request域中.
        //model.addAttribute("redirectUrl",redirectUrl);
        return "/";
    }

    /**
     * 检查是否有全局会话.
     * @param redirectUrl 客户端被拦截的请求地址
     * @param session      统一认证中心的会话对象
     * @param model        数据模型
     * @return              视图地址
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(String redirectUrl, HttpSession session, Model model, HttpServletResponse res){
        log.info(session.getId()+"   ID");
        log.info("checkLogin now:{}",redirectUrl);
        //1.判断是否有全局的会话
        //从会话中获取令牌信息,如果取不到说明没有全局会话,如果能取到说明有全局会话
        String token = (String) session.getAttribute("token");
        log.info("token:{}",token);
        if(StringUtils.isEmpty(token)){
            //表示没有全局会话
           // model.addAttribute("redirectUrl",redirectUrl);
            //跳转到统一认证中心的登陆页面.已经配置视图解析器,
            // 会找/WEB-INF/views/login.jsp视图
            try {
                res.sendRedirect("http://localhost:18080?redirectUrl="+redirectUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }else{
            //有全局会话
            //目前这段逻辑我们先不写,按着图解流程编写代码
            try {
                res.sendRedirect(redirectUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
    @RequestMapping("/get")
    @ResponseBody
    public String get(HttpSession session){
        log.info(session.getId());
        return (String) session.getAttribute("token");
    }

    @RequestMapping("/set")
    @ResponseBody
    public void set(HttpSession session){
        log.info(session.getId());
        session.setAttribute("token","1231");
    }
    @RequestMapping("/clear")
    @ResponseBody
    public String clear(HttpSession session){
        session.invalidate();
        return (String) session.getAttribute("token");
    }
}
