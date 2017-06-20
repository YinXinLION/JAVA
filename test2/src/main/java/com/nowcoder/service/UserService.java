package com.nowcoder.service;

import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;
import com.nowcoder.util.LoginUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoginTicketDAO loginTicketDAO;
    //获取用户 通过id
    public User getUser(int id) {
        return userDAO.selectById(id);
    }

    public Map<String, String> register(String username,String password){
        Map<String,String> map = new HashMap<String,String>();
        if (StringUtils.isBlank(username)){
            map.put("msg","用户名为空");
            return map;
        }
        User user = userDAO.selectByName(username);
        if (user != null){
            map.put("msg","用户已注册");
            return map;
        }
        //准备注册
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setPassword(LoginUtil.getMd5(password+user.getSalt()));
        user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));



        userDAO.addUser(user);
        //下发ticket
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    public Map<String,String> Login(String username,String password){
        User user = userDAO.selectByName(username);
        Map<String,String> map = new HashMap<String,String>();
        if (user == null){
            map.put("msg","用户账号不存在");
            return map;
        }
        String validate = LoginUtil.getMd5(password + user.getSalt());
        if (!validate.equals(user.getPassword())){
            map.put("msg","用户名或密码错误");
            return map;
        }
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        map.put("userId",String.valueOf(user.getId()));
        return map;
    }

    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date now = new Date();
        now.setTime((1000 * 60 * 60 * 24 * 1) + now.getTime());//设置有效期1天

        loginTicket.setExpired(now);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketDAO.addTicket(loginTicket);
        return  loginTicket.getTicket();
    }

    public User selectByName(String name){
        return userDAO.selectByName(name);
    }

    public User selectById(int id){
        return userDAO.selectById(id);
    }

    public void logout(String ticket){
//        System.out.println(ticket);
        loginTicketDAO.updateStatus(ticket,1);
    }

}
