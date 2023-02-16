package com.zhengpc.myspringboot.annotation;

import org.junit.jupiter.api.Test;

public class SysLogTest {

    @Test
    //@SysLog(name = "test1",model = "SysLogTest",code = {"hello", "world"})
    public void test1(){
        System.out.println("test");
    }
}
