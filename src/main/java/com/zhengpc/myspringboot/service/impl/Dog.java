package com.zhengpc.myspringboot.service.impl;

import com.zhengpc.myspringboot.service.Animal;
import org.springframework.stereotype.Component;

/**
 * @author zhengpengcheng
 */
@Component
public class Dog implements Animal {
    @Override
    public String getName() {
        return "i am dog";
    }
}
