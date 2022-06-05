package com.zhengpc.myspringboot.config;


import com.zhengpc.myspringboot.componet.LoginInterceptor;
import com.zhengpc.myspringboot.componet.MyLocalResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhengpengcheng
 */
@Slf4j
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        registry.addInterceptor(new LoginInterceptor())
                //拦截所有请求，包括静态资源文件
                .addPathPatterns("/**")
                //放行登录页，登陆操作，静态资源
                .excludePathPatterns("/", "/login", "/index.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //当访问 “/” 或 “/index.html” 时，都直接跳转到登陆页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        //添加视图映射 main.html 指向  dashboard.html
        registry.addViewController("/main.html").setViewName("main");
    }

    /**
     * 将自定义的区域信息解析器以组件的形式添加到容器中
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
