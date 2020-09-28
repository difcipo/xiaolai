package com.cai.xiaolai.config;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.service.EmplyeeLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;

@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private MyUserDetailService userDetailService;

    @Autowired
    private EmplyeeLogin emplyeeLogin;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/","/toLogin","/data/**").permitAll()
            .antMatchers("/toFileM","/toDepart","/empManager","/index/toMain")
                .hasAnyRole("ADMIN","USERZ","USERT")
            .antMatchers("/toReciveMsg","/toMessage","/toVacateM").hasAnyRole("ADMIN","USERZ","USERT","USER")
            .antMatchers("/**").authenticated()
                .anyRequest()
            .authenticated();

        http.formLogin()
            .loginPage("/toLogin")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/login")
            .successForwardUrl("/index/toMain");

        http.logout().logoutSuccessUrl("/toLogin").permitAll();

        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        List<Emplyee> empList = emplyeeLogin.getEmpList();
        for (Emplyee emp : empList){
            System.out.println(emp.getUsername()+"=="+emp.getPassword()+"=="+emp.getRole().getRoleName());
            auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                    .withUser(emp.getUsername())
                    .password(new BCryptPasswordEncoder().encode(emp.getPassword()))
                    .roles(emp.getRole().getRoleName());
        }
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("tom")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("小刘")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("USER");

//        auth.userDetailsService(userDetailService)
//                .passwordEncoder(new BCryptPasswordEncoder());


       // auth.userDetailsService(userDetailService);

    }


}
