package com.zhengpc.myspringboot.service.impl;

import com.zhengpc.myspringboot.service.Animal;
import org.springframework.stereotype.Component;

/**
 * @author zhengpengcheng
 */
@Component
public class Cat implements Animal {
    @Override
    public String getName() {
        return "i am cat";
    }
}
