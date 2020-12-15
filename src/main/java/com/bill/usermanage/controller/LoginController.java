package com.bill.usermanage.controller;

import com.bill.usermanage.dao.UserDao;
import com.bill.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;
//    @RequestMapping("/login")
//    public String login(@RequestParam(name = "username") String loginUsername, @RequestParam(name = "password") String loginPassword, Model model, HttpSession session, HttpServletResponse response,HttpServletRequest request){
//
//        User user = userDao.getUser(loginUsername, loginPassword);
//        if(user!=null){
//            session.setAttribute("loginUser",user.getName());
////            session.setMaxInactiveInterval(60);
//            Cookie cookie = new Cookie("billUser",user.getName());
////            cookie.setMaxAge(60);
//            response.addCookie(cookie);
//            return "redirect:/index.html";
//        }else{
//            model.addAttribute("msg","用户名或者密码错误");
//            return "login";
//        }
//
//    }
   /* @RequestMapping("/logout")
    public  String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response){
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("billUser".equals(cookie.getName())) {
                //设置时长
                cookie.setMaxAge(0);
                //响应给客户端
                response.addCookie(cookie);
            }
        }
        return "redirect:/login.html";
    }
*/

}
