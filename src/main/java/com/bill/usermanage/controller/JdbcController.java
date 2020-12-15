package com.bill.usermanage.controller;

import com.bill.usermanage.dao.DepartmentDao;
import com.bill.usermanage.mapper.UserMapper;
import com.bill.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Controller
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;
    /**
     * jdbc
     * @return
     */
    @RequestMapping("/selectUser")
    @ResponseBody
    public List<User> selectDate(){
       /* String sql = "select * from b_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);*/
        List<User> users = userMapper.selectUserList();
        return users;
    }
}
