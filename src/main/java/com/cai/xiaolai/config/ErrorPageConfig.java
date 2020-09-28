package com.cai.xiaolai.config;


import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {


    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        System.out.println("ErrorPage**********");
        ErrorPage error403Page=new ErrorPage(HttpStatus.FORBIDDEN,"/403.html" );
        ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/");
//        ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error500");
        registry.addErrorPages(error403Page,error401Page);
    }
}
