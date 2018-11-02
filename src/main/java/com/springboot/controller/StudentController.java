package com.springboot.controller;


import com.springboot.model.User;
import com.springboot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {


    @Autowired
    private RedisTemplate redisCacheTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/setString")
    public String setString(String key, String value){
        User user = new User();
/*        user.setName("xc");*/
        redisUtil.set("qwe", "ssss111222222222222221");
        /*User map2 = (User) redisCacheTemplate.opsForValue().get("qwe");
        System.out.println(map2.getName());*/
        return "done";
    }

}
