package com.zhengpc.myspringboot.bytecode.javassist;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zhengpengcheng
 * @description 测试使用Javassist生成第一个类HelloWorld
 */
public class GenerateHelloWorldClass {

    /**
     * 创建HelloWorld的类，并返回HelloWorld的Class实例
     */
    public static Class createHelloWorld()throws Exception{
        //使用默认的ClassPool
        ClassPool pool = ClassPool.getDefault();
        //创建一个空类
        CtClass ctClass = pool.makeClass("com.zhengpc.myspringboot.bytecode.javassist.HelloWorld");
        //添加一个main方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "main", new CtClass[]{pool.get(String[].class.getName())}, ctClass);
        //将main方法声明为public static类型
        ctMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
        //设置方法体
        ctMethod.setBody("{" +
                "System.out.println(\"this is Javassist HelloWorld\");" +
                "}");
        ctClass.addMethod(ctMethod);

        //将生成的类的class文件输出的磁盘
        ctClass.writeFile();

        //返回HelloWorld的Class实例
        return ctClass.toClass();

    }

    public static void main(String[] args) throws Exception {
        Class clazz = createHelloWorld();
        Object obj = clazz.newInstance();
        Method mainMethod = clazz.getMethod("main", new Class[]{String[].class});
        mainMethod.invoke(obj, new String[1]);
    }
}