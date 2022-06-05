package com.zhengpc.myspringboot;

import com.zhengpc.myspringboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired
    Person person;
    //IOC容器
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("personService");
        if(b){
            System.out.println("personService 已经添加到 IOC 容器中");
        } else {
            System.out.println("personService 没添加到 IOC 容器中");
        }
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
