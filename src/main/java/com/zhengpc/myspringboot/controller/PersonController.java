package com.zhengpc.myspringboot.controller;

import com.zhengpc.myspringboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhengpengcheng
 */
@Controller
public class PersonController {
    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping(value = "/person")
    public Person getPerson() {
        return person;
    }
}
