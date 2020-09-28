package com.cai.xiaolai.controller;

import com.cai.xiaolai.entity.Department;
import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.entity.Role;
import com.cai.xiaolai.mapper.RoleMapper;
import com.cai.xiaolai.service.DepartmentService;
import com.cai.xiaolai.service.EmplyeeLogin;
import com.cai.xiaolai.service.EmplyeeManager;
import com.cai.xiaolai.service.RoleService;
import com.cai.xiaolai.utils.FormatUUID;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private EmplyeeLogin emplyeeLogin;

    @Autowired
    private EmplyeeManager emplyeeManager;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;
//主页


    @RequestMapping("/index/toMain")
    public ModelAndView login(HttpServletRequest request,Emplyee emp){
        System.out.println(emp);
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        Emplyee emplyee = emplyeeLogin.getEmplyee(emp);
        session.setAttribute("role",emplyee.getRole().getRoleName());
        session.setAttribute("depart",emplyee.getDepartment().getDepartName());
        session.setAttribute("emplyee",emplyee);
        model.setViewName("index");
        return model;

    }

    @RequestMapping("/empManager")
    public String empManager(Model model,@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,@RequestParam(defaultValue = "") String likename){
        PageInfo<Emplyee> emplyeeList = emplyeeManager.getEmplyeeList(pageNum, 3,likename);
        model.addAttribute("pageInfo",emplyeeList);
        return "emplyeeManager";
    }

//    跳转到添加页面
    @RequestMapping("/toEmpAdd")
    public String toEmpAdd(Model model){
        List<Department> depList = departmentService.getDepList();
        List<Role> roleList = roleService.getRoleList();
        model.addAttribute("depList",depList);
        model.addAttribute("roleList",roleList);
        return "empadd";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Model model,Emplyee emplyee){
        emplyee.setNumber(FormatUUID.getUUID("U",8));
        emplyeeManager.save(emplyee);
        return "redirect:/empManager";
    }

    //跳转到员工编辑页面
    @RequestMapping("/toEmpEdit/{id}")
    public String toEmpEdit(Model model,@PathVariable("id") int id){
        Emplyee emp = emplyeeManager.getEmpById(id);
        List<Role> roleList = roleService.getRoleList();
        List<Department> depList = departmentService.getDepList();
        model.addAttribute("emp",emp);
        model.addAttribute("roleList",roleList);
        model.addAttribute("depList",depList);
        return "empedit";
    }

    //修改员工信息
    @RequestMapping("/edit")
    public String edit(Emplyee emplyee){
        emplyeeManager.update(emplyee);
        return "redirect:/index/toMain";
    }




}
