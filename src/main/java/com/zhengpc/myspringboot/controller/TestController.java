package com.zhengpc.myspringboot.controller;

import com.zhengpc.myspringboot.annotation.SysLog;
import com.zhengpc.myspringboot.config.MyAppConfig;
import com.zhengpc.myspringboot.service.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpengcheng
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/test")
public class TestController {
    //注入MyAppConfig里的Bean
    private final Animal animal;

    @ResponseBody
    @GetMapping(value = "/test")
    @SysLog(name = "getPerson")
    public String getPerson() {
        return "syslog";
    }

    @ResponseBody
    @RequestMapping("/print")
    public Map<String, String> print(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("getMethod", request.getMethod());
        map.put("getRequestURI", request.getRequestURI());
        map.put("getRequestURL", request.getRequestURL().toString());
        map.put("getServletPath", request.getServletPath());
        map.put("getQueryString", request.getQueryString());
        map.put("getContextPath", request.getContextPath());
        return map;
    }

    @ResponseBody
    @RequestMapping("/getAnimal")
    public String getAnimal() {
        return animal.getName();
    }
}
