package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.Role;
import com.cai.xiaolai.mapper.RoleMapper;
import com.cai.xiaolai.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }
}
