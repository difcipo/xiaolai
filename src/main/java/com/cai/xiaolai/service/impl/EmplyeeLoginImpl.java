package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.entity.Role;
import com.cai.xiaolai.mapper.EmplyeeMapper;
import com.cai.xiaolai.service.EmplyeeLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmplyeeLoginImpl implements EmplyeeLogin {


    @Autowired
    public EmplyeeMapper emplyeeMapper;

    @Override
    public Emplyee getEmplyee(Emplyee emplyee) {
        Emplyee emp = emplyeeMapper.getEmplyee(emplyee.getUsername(), emplyee.getPassword());

        return emp;


    }

    @Override
    public List<Emplyee> getEmpList() {
        return emplyeeMapper.getEmplyeeList(null);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            Emplyee emplyee = emplyeeMapper.getEmplyee(s, "");

            if(emplyee==null){
                return null;
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Role role = emplyee.getRole();
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            UserDetails userDetails = new User(emplyee.getUsername(),"{noop}"+emplyee.getPassword(),authorities);
            return userDetails;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception::"+e);
            return null;
        }

    }


}
