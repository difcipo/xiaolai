package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.Emplyee;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmplyeeLogin extends UserDetailsService{
    Emplyee getEmplyee(Emplyee emplyee);

    List<Emplyee> getEmpList();

}
