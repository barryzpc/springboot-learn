package com.zhengpc.myspringboot.controller;

import com.zhengpc.myspringboot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhengpengcheng
 */
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private User user;

    @RequestMapping("/user/login")
    public String doLogin(@RequestParam("username") String userName, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        if (userName.equals(user.getUserName()) && password.equals(user.getPassWord())) {
            session.setAttribute("loginUser", user);
            log.info("登陆成功，用户名：" + user.getUserName());
            //防止重复提交使用重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            log.error("登陆失败");
            return "login";
        }
    }
}
