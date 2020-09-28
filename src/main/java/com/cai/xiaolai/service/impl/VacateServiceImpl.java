package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.Vacate;
import com.cai.xiaolai.mapper.VacateMapper;
import com.cai.xiaolai.service.VacateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacateServiceImpl implements VacateService {

    @Autowired
    private VacateMapper vacateMapper;
    @Override
    public PageInfo<Vacate> getVacateList(int pageNum,int pageSize,String num) {
        PageHelper.startPage(pageNum,pageSize);
        List<Vacate> vacateList = vacateMapper.getVacateList(num);
        PageInfo<Vacate> pageInfo = new PageInfo<>(vacateList);
        return pageInfo;
    }

    @Override
    public void save(Vacate vacate) {
        vacateMapper.save(vacate);
    }
}
