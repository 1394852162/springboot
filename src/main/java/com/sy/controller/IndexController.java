package com.sy.controller;

import com.sy.pojo.Resource;
import com.sy.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by haswell on 2018/4/4.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private Resource resource;

    @RequestMapping("/resource")
    @ResponseBody
    public JSONResult Resource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JSONResult.ok(bean);
    }


    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        System.out.println("*************");
        return "thymeleaf/center/center";
    }

    @RequestMapping("exception")
    public String exception(){

        int a = 1/0;
        return "thymeleaf/center/center";
    }

}
