package com.zhengpc.myspringboot.service.impl;

import com.zhengpc.myspringboot.bean.User;
import com.zhengpc.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhengpengcheng
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private User user;

    @Override
    public User getUserInfo() {
        return user;
    }
}
