package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> getDepList(@Param("depLike") String depLike);

    void save(@Param("department") Department department);

    Department getDepartById(@Param("id") int id);

    void update(@Param("department") Department department);
}
