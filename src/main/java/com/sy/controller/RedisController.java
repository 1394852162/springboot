package com.sy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.sy.pojo.User;
import com.sy.utils.JSONResult;
import com.sy.utils.JsonUtils;
import com.sy.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redisOperator;

	
	@RequestMapping("/test")
	public JSONResult test(int id) {
		

		User user = new User();
		user.setId(id);

		strRedis.opsForValue().set(id+"", JsonUtils.objectToJson(user));

		
		return JSONResult.ok(strRedis.opsForValue().get(id+""));
	}

	@RequestMapping("/test1")
	public JSONResult test1() {

		User user = new User();
		user.setId(1);
		user.setName("LeeJp");
		user.setBirthDate(new Date());
		user.setNote("测试一");

		List list  = new ArrayList();
		list.add(1);
		list.add("list1");
		list.add("59874");
		redisOperator.set("testJson",JsonUtils.objectToJson(user));
		return JSONResult.ok(strRedis.opsForValue().get("testJson"));
	}



}