package com.bill.usermanage.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        String name = "";
            for (Cookie cookie : cookies) {
                if ("billUser".equals(cookie.getName())) {
                    name = cookie.getValue();
                    request.getSession().setAttribute("loginUser",name);
                    flag = true;
                    break;
                }
            }

       if(StringUtils.isEmpty(name)){
           request.setAttribute("msg","用户未登录，请先登陆！");
           request.getRequestDispatcher("/login.html").forward(request,response);
           return false;
       }

        String loginUser = (String) request.getSession().getAttribute("loginUser");
        if (StringUtils.isEmpty(loginUser)) {
            request.setAttribute("msg","用户未登录，请先登陆！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }

            return flag;

    }
}
