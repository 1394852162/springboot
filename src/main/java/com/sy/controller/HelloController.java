package com.sy.controller;

import com.sy.pojo.User;
import com.sy.pojo.Users;
import com.sy.service.UsersService;
import com.sy.utils.JSONResult;
import com.sy.utils.JsonUtils;
import com.sy.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by haswell on 2018/4/4.
 */
@RestController
public class HelloController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping("/hello")
    public String Hello(){

        return "hello boot";
    }

    @RequestMapping("/helloJson")
    public JSONResult HelloJson(){
        User user = new User();
        user.setId(1);
        user.setName("小明");
        user.setPassword("123456");
        user.setBirthDate(new Date());

        return JSONResult.ok(user);
    }

    @RequestMapping("/list")
    public JSONResult UserList(){
        //git提交
        List<Users> list = usersService.getListUsers(1);
        redisOperator.set("ListJson", JsonUtils.objectToJson(list));
        return JSONResult.ok(redisOperator.get("ListJson"));
    }




}
