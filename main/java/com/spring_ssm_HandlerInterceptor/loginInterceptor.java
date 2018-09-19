package com.spring_ssm_HandlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//拦截器

public class loginInterceptor implements HandlerInterceptor {
    //进入handler方法之前执行
    //用于身份验证、身份授权
    //比如身份认证，如果身份认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        //公共url全部通过
        if (url.indexOf("login.action") > 0) {
            return true;
        }

        //session存在用户通过
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null && !username.equals("")){
            return true;
        }


            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //false表示拦截不向下执行
            //true表示放行
            return false;
    }

    //进入handler方法之后，返回ModelAndView之前执行
    //应用场景从ModelAndView出发，将公用的模型数据（比如导航兰）在这里传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //执行handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
