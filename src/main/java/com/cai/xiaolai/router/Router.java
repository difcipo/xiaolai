package com.cai.xiaolai.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@Controller
public class Router {

    @RequestMapping({"/","/toLogin"})
    public String toLogin(){
        return "OALogin";
    }

    //个人信息
    @RequestMapping("/personInfo")
    public String personInfo(){
        return "personMessagInfo";
    }

    @RequestMapping("/403.html")
    public String error(){
        return "403";
    }



}
