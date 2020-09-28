package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.mapper.EmplyeeMapper;
import com.cai.xiaolai.service.EmplyeeManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplyeeMapperImpl implements EmplyeeManager {

    @Autowired
    public EmplyeeMapper emplyeeMapper;

    @Override
    public PageInfo<Emplyee> getEmplyeeList(int pageNum,int  pageSize,String likename) {
        PageHelper.startPage(pageNum,pageSize);
        List<Emplyee> emplyeeList = emplyeeMapper.getEmplyeeList(likename);
        PageInfo<Emplyee> pageInfo = new PageInfo<>(emplyeeList);
        return pageInfo;
    }

    @Override
    public void save(Emplyee emplyee) {
        emplyeeMapper.save(emplyee);
    }

    @Override
    public Emplyee getEmpById(int id) {
        return emplyeeMapper.getEmpById(id);
    }

    @Override
    public void update(Emplyee emp) {
        emplyeeMapper.update(emp);
    }

}
