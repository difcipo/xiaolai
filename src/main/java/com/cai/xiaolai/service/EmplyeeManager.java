package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.Emplyee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmplyeeManager {
    PageInfo<Emplyee> getEmplyeeList(int pageNum,int pageSize,String likename);

    void save(Emplyee emplyee);

    Emplyee getEmpById(int id);

    void update(Emplyee emp);
}
