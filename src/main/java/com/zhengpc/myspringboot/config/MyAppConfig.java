package com.zhengpc.myspringboot.config;

import com.zhengpc.myspringboot.service.Animal;
import com.zhengpc.myspringboot.service.impl.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengpengcheng
 */
@Configuration
public class MyAppConfig {
    /**
     * 与 <bean id="personService" class="PersonServiceImpl"></bean> 等价
     * 该方法返回值以组件的形式添加到容器中
     * 方法名是组件 id（相当于 <bean> 标签的属性 id)
     *//*
    @Bean
    public PersonService personService() {
        //在容器中添加了一个组件:peronService
        return new PersonServiceImpl();
    }*/

    @Bean
    public Animal animal() {
        //在容器中添加了一个组件:peronService
        return new Dog();
    }

    /*@Bean
    public UserService userService() {
        //在容器中添加了一个组件:userService
        return new UserServiceImpl();
    }*/
}
