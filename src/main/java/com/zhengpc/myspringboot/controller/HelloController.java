package com.zhengpc.myspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author zhengpengcheng
 */
@Controller
public class HelloController {

//    @ResponseBody
    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        //通过 map 向前台页面传递数据
        map.put("title", "zhengpc");
        map.put("name", "springBoot");
        return "hello";
    }
}
