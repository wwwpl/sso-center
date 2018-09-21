package com.wf.wf.sso.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author wangfei
 * @date 2018/9/20 16:28
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class HttpSessionConfig {
    //不需要写任何代码
}