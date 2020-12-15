package com.bill.usermanage.controller;

import com.bill.usermanage.dao.DepartmentDao;
import com.bill.usermanage.dao.UserDao;
import com.bill.usermanage.pojo.Department;
import com.bill.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/tables")
    public String list(Model model){
        Collection<User> userAll = userDao.getUserAll();
        model.addAttribute("users",userAll);
        return "tables.html";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "register.html";
    }
    @PostMapping("/addUser")
    public String addUser(User user){
        userDao.saveUser(user);
        return "redirect:/tables";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id){
        userDao.deleteUser(id);
        return "redirect:/tables";
    }



}
