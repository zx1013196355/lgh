package com.spring_ssm_controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //登陆
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        session.setAttribute("username",username);

        return "redirect:/students/student.action";
    }


    //退出
    @RequestMapping("loginout")
    public String loginout(HttpSession session) {
        session.removeAttribute("username");

        return "redirect:/students/student.action";
    }
}
