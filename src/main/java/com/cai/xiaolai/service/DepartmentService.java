package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.Department;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepList();
    PageInfo<Department> getDepartList(int pageNum,int pageSize,String depLike);
    void save(Department department);
    Department getDepartById(int id);
    void update(Department department);
}
