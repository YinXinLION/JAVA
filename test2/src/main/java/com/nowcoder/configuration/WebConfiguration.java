package com.nowcoder.configuration;

import com.nowcoder.interceptor.JumpIterceptor;
import com.nowcoder.interceptor.LoginIterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 殷鑫 on 2017/1/29.
 */
//注册拦截器
@Component
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    LoginIterceptor loginIterceptor;
    @Autowired
    JumpIterceptor jumpIterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIterceptor);//注册登录拦截器
        registry.addInterceptor(jumpIterceptor).addPathPatterns("/user/*");//注册跳转登录拦截器
        super.addInterceptors(registry);
    }
}
