package com.cai.xiaolai.controller;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.entity.Vacate;
import com.cai.xiaolai.service.VacateService;
import com.cai.xiaolai.utils.FormatNumber;
import com.cai.xiaolai.utils.FormatUUID;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VacateController {

    @Autowired
    private VacateService vacateService;

    @RequestMapping("/toVacateM")
    public String toVacateM(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(defaultValue = "") String num){
        PageInfo<Vacate> pageInfo = vacateService.getVacateList(pageNum, 3,num);
        model.addAttribute("pageInfo",pageInfo);
        return "vacateManager";
    }

    @RequestMapping("/toApplyVacate")
    public String toApplyVacate(){
        return "vacateapply";
    }
    @RequestMapping("/addVacate")
    public String addVacate(HttpServletRequest request,Vacate vacate){
        Emplyee emplyee = (Emplyee) request.getSession().getAttribute("emplyee");

        vacate.setNumber(FormatUUID.getUUID("AL",8));
        vacate.setVacateTime(FormatNumber.format("YYYY-mm-dd hh:mm",""));
        vacate.setState(1);
        vacateService.save(vacate);
        return "redirect:/toVacateM";
    }
}
