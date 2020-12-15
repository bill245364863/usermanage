package com.bill.usermanage.dao;

import com.bill.usermanage.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {

    public static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101,new Department(101,"人力资源部门"));
        departmentMap.put(102,new Department(102,"财务部门"));
        departmentMap.put(103,new Department(103,"技术部门"));
        departmentMap.put(104,new Department(104,"运维部门"));
    }

    public Department getDepartment(Integer id){
      return   departmentMap.get(id);
    }

    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }
}
