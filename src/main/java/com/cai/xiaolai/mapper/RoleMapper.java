package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<Role> getRoleList();
}
