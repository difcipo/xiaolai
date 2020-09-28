package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.Emplyee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmplyeeMapper {
    Emplyee getEmplyee(@Param("username") String username, @Param("passwd") String passwd);

    List<Emplyee> getEmplyeeList(@Param("likename") String likename);

    void save(@Param("emplyee") Emplyee emplyee);

    Emplyee getEmpById(@Param("id") int id);

    void update(@Param("emp") Emplyee emp);


}
