package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.Vacate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VacateService {
    PageInfo<Vacate> getVacateList(int pageNum,int pageSize,String num);

    void save(Vacate vacate);
}
