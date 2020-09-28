package com.cai.xiaolai.config;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.mapper.EmplyeeMapper;
import com.cai.xiaolai.service.EmplyeeLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    private EmplyeeLogin emplyeeLogin;

    @Autowired
    private EmplyeeMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        Emplyee emplyee = mapper.getEmplyee(s, "");
        authorities.add(new SimpleGrantedAuthority(emplyee.getRole().getRoleName()));
        UserDetails user = new User(emplyee.getUsername(), "{noop}" + emplyee.getPassword(), authorities);
        return user;
    }
}
