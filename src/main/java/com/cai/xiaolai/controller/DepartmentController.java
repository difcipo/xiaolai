package com.cai.xiaolai.controller;

import com.cai.xiaolai.entity.Department;
import com.cai.xiaolai.service.DepartmentService;
import com.cai.xiaolai.utils.FormatUUID;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/toDepart")
    public String toDepartManager(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){

        PageInfo<Department> pageInfo = departmentService.getDepartList(pageNum,3,"");
        model.addAttribute("pageInfo",pageInfo);
        return "departmanager";
    }

    //跳转到员工添加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "departadd";
    }

    @RequestMapping("/addDepart")
    public String addDepart(Model model ,Department department){
        department.setNumber(FormatUUID.getUUID("D",8));
        departmentService.save(department);
        return "redirect:/toDepart";
    }

    //部门编辑
    @RequestMapping("/toDepartEdit/{departId}")
    public String toDepartEdit(Model model,@PathVariable("departId") int departId){
        Department depart = departmentService.getDepartById(departId);

        List<Department> depList = departmentService.getDepList();
        model.addAttribute("depart",depart);
        model.addAttribute("depList",depList);
        return "departedit";
    }

    @RequestMapping("/departEdit")
    public String departEdit(Department department){
        departmentService.update(department);
        return "redirect:/toDepart";
    }

    //模糊查询部门
    @RequestMapping("/selLikeDep")
    public String selLikeDep(Model model,String deplike,@RequestParam(defaultValue = "1") int pageNum){
        PageInfo<Department> pageInfo = departmentService.getDepartList(pageNum, 3, deplike);
        model.addAttribute("pageInfo",pageInfo);
        return "departmanager";
    }

}
