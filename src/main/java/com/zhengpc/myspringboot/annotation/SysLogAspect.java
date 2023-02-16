package com.zhengpc.myspringboot.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhengpengcheng
 */
@Aspect
@Component
public class SysLogAspect {

    /**
     * 指定自定义注解为切入点
     */
    @Pointcut("@annotation(com.zhengpc.myspringboot.annotation.SysLog)")
    public void logPoint(){
    }

    @Before("logPoint()")
    public void before(JoinPoint joinPoint){

    }

    /**
     * 环绕通知，调用目标方法
     */
    @Around("logPoint()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            SysLog sysLog = method.getAnnotation(SysLog.class);
            // 获取注解的属性值
            String[] code = sysLog.code();
            String name = sysLog.name();
            String model = sysLog.model();
            System.out.println("code：" + Arrays.toString(code));
            System.out.println("name：" + name);
            System.out.println("model：" + model);
        }
        return proceedingJoinPoint.proceed();
    }

}
