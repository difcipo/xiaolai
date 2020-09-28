package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.Vacate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VacateMapper {

    List<Vacate> getVacateList(@Param("num") String num);

    void save(@Param("vacate") Vacate vacate);
}
