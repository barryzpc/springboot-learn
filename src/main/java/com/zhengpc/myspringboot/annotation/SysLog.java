package com.zhengpc.myspringboot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhengpengcheng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 所属模块
     * @return
     */
    String model() default "";

    /**
     * 名称
     * @return
     */
    String name() default "";

    /**
     * 功能code
     * @return
     */
    String[] code() default "";
}
