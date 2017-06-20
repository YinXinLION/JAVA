package com.nowcoder.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.api.scripting.JSObject;

import java.util.Map;

/**
 * Created by 殷鑫 on 2017/1/31.
 */
public class WendaUtil {
    public static int  SYSTEM_ADMIN = 999;
    public static String getJSONString(int code, String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        return jsonObject.toJSONString();
    }
    public static String getJSONString(int code){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        return jsonObject.toJSONString();
    }

    public static String getJSONString(int code, Map<String,Object> map){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("map",map);
        return jsonObject.toJSONString();
    }
}
