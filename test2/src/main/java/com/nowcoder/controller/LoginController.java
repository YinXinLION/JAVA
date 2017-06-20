package com.nowcoder.controller;

import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventProducer;
import com.nowcoder.async.EventType;
import com.nowcoder.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 殷鑫 on 2017/1/28.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    UserService userService;
    @Autowired
    EventProducer eventProducer;
    @RequestMapping(path = {"/login"},method = {RequestMethod.POST})
    public String Login(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("next") String next,
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        try {
            Map<String,String> map = userService.Login(username,password);
            if (map.containsKey("ticket"))
            {
                Cookie cookie = new Cookie("ticket",map.get("ticket"));
                cookie.setPath("/");
                cookie.setMaxAge(3600*24*5);
                response.addCookie(cookie);

                eventProducer.fireEvent(new EventModel()
                        .setType(EventType.LOGIN)
                        .setExt("username", username)
                        .setExt("email", "www.yinxin2010@qq.com")
                        .setActorId((Integer.parseInt(map.get("userId"))))
                );//加入事件发送邮件;

                if (StringUtils.isBlank("next")){
                    return "redirect:/";
                }else {
                    return "redirect:"+next;
                }

            }else {
                if (map.containsKey("msg")) {
                    request.setAttribute("msg",map.get("msg"));
                    return "login";
                }
            }
        }catch (Exception e) {
            return "login";
        }
        return "index";
    }

    @RequestMapping(path = {"/register"},method = {RequestMethod.POST})
    public String Register(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("next") String next,
            @RequestParam("username") String username,
            @RequestParam("password") String password){

        try {
            Map<String,String> map = userService.register(username,password);
            if (map.containsKey("ticket"))
            {
                String ticket = map.get("ticket");
                Cookie cookie = new Cookie("ticket",ticket);
                cookie.setPath("/");
                cookie.setMaxAge(3600*24*5);
                response.addCookie(cookie);

                if(StringUtils.isBlank(next)) {
                    return "redirect:/";
                }else {
                    return "redirect:"+next;
                }

            }else {
                if(map.containsKey("msg")) {
                    request.setAttribute("msg",map.get("msg"));
                }
                return "login";
            }
        }catch (Exception e){
            logger.error("注册异常",e.getMessage());
            return "login";
        }
    }

    @RequestMapping(path = {"/logout"})
    public String logout(@CookieValue("ticket") String ticket){

        userService.logout(ticket);
        return "redirect:/";
    }
}
