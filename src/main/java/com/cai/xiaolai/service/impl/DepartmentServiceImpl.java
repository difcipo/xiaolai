package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.Department;
import com.cai.xiaolai.mapper.DepartmentMapper;
import com.cai.xiaolai.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepList() {
        return departmentMapper.getDepList("");
    }

    @Override
    public PageInfo<Department> getDepartList(int pageNum,int pageSize,String depLike){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> depList = departmentMapper.getDepList(depLike);
        PageInfo<Department> pageInfo = new PageInfo<>(depList);
        return pageInfo;
    }

    @Override
    public void save(Department department) {
        departmentMapper.save(department);
    }

    @Override
    public Department getDepartById(int id) {
        return departmentMapper.getDepartById(id);
    }

    @Override
    public void update(Department department) {
        System.out.println(department);
        departmentMapper.update(department);
    }
}
