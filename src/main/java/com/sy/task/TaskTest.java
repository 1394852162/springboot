package com.sy.task;

import com.sy.pojo.Users;
import com.sy.service.UsersService;
import com.sy.utils.JsonUtils;
import com.sy.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created by haswell on 2018/4/8.
 */
@Component
public class TaskTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisOperator redisOperator;

    @Scheduled(fixedRate = 60000)
    public void TaskRedis(){


        List<Users> list = usersService.getListUsers(1);
        redisOperator.set("ListJson", JsonUtils.objectToJson(list));
    }
}
