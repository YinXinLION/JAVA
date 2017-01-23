package com.lion.controller;

import com.lion.model.User;
import com.lion.service.webservice;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.*;

/**
 * Created by 殷鑫 on 2017/1/14.
 */
@Controller
public class IndexController {
    @Autowired
    private webservice hello;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "asdad";
    }

    @RequestMapping("/profile/{groupid}/{userid}")
    @ResponseBody
    public String helloindex(@PathVariable("groupid") String groupid,
                             @PathVariable("userid") String userid,
                             @RequestParam(value = "type")int type,
                             @RequestParam(value = "key")int key){
        return String.format("{%s},{%s},{%d},{%d}",groupid,userid,type,key);

    }
    @RequestMapping("/test")
    public String www(Model model)
    {
        model.addAttribute("type","asdad");
        List<String> colors = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
        model.addAttribute("colors",colors);
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0;i < 4; i++)
        {
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);
        User user = new User("Lion");
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/ex")
    public void ex() throws Exception {
        throw new Exception("error lion!");
    }
    @ExceptionHandler
    @ResponseBody
    public String error(Exception e){
        return e.getMessage() +hello.getMessage();
    }
}
