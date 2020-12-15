package com.bill.usermanage.dao;

import com.bill.usermanage.pojo.Department;
import com.bill.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDao {
    @Autowired
    private DepartmentDao departmentDao;

    public  static Map<Integer, User> userMap = null;

    static {
        userMap = new HashMap<Integer, User>();
        userMap.put(101,new User(101,"123","zhangsan","245364863@qq.com",new Department(101,"人力资源部门")));
        userMap.put(102,new User(102,"123","lisi","245364863@qq.com",new Department(102,"财务部门")));
        userMap.put(103,new User(103,"123","zhansan","245364863@qq.com",new Department(103,"技术部门")));
        userMap.put(104,new User(104,"123","bill","245364863@qq.com",new Department(104,"运维部门")));
    }
    private static     Integer id = 105;
    public User getUser(String name,String password){
        Set<Integer> integerSet = userMap.keySet();
        for (Integer integer : integerSet) {
            User user = userMap.get(integer);
            String name1 = user.getName();
            String password1 = user.getPassword();
            if(name.equals(name1) && password.equals(password1)){
                return user;
            }

        }
        return null;
    }


    public Collection<User> getUserAll(){
        return userMap.values();
    }

    /**
     * 注册用户
     * @param user
     */
    public void  saveUser(User user){
        if(user.getId()== null){
            user.setId(id++);
        }
        user.setDepartment(departmentDao.getDepartment(user.getDepartment().getId()));
        userMap.put(user.getId(),user);
    }


    public void deleteUser(Integer id){
        userMap.remove(id);
    }
}
