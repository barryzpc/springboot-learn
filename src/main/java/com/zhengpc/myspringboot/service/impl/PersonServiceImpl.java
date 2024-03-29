package com.zhengpc.myspringboot.service.impl;

import com.zhengpc.myspringboot.bean.Person;
import com.zhengpc.myspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengpengcheng
 */
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private Person person;

    @Override
    public Person getPersonInfo() {
        return person;
    }
}
