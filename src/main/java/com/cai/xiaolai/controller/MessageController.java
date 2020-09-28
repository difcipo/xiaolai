package com.cai.xiaolai.controller;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.entity.Message;
import com.cai.xiaolai.service.EmplyeeLogin;
import com.cai.xiaolai.service.MessageService;
import com.cai.xiaolai.utils.FormatNumber;
import com.cai.xiaolai.utils.FormatUUID;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private EmplyeeLogin emplyeeLogin;


    //消息发送
    @RequestMapping("/toMessage")
    public String toMessage(HttpServletRequest request,Model model,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "") String recivename){
        Emplyee emplyee = (Emplyee) request.getSession().getAttribute("emplyee");
        PageInfo<Message> pageInfo = messageService.getMessageList(pageNum, 3, recivename,emplyee.getId(),0);
        model.addAttribute("pageInfo",pageInfo);
        return "messagesend";
    }

    @RequestMapping("/toAddMsg")
    public String toAddMsg(Model model){
        List<Emplyee> empList = emplyeeLogin.getEmpList();
        model.addAttribute("empList",empList);
        return "messagadd";
    }

    @RequestMapping("/sendmsg")
    public String sendmsg(HttpServletRequest request,Message message){
        message.setNumber(FormatUUID.getUUID("MS",8));
        message.setSendTime(FormatNumber.format("YYYY-mm-dd hh:mm:ss",""));
        Emplyee emplyee = (Emplyee) request.getSession().getAttribute("emplyee");
        message.setSendName(emplyee);
        message.setState(0);
        messageService.save(message);
        return "redirect:/toMessage";
    }

    //消息接收
    @RequestMapping("/toReciveMsg")
    public String toReciveMsg(HttpServletRequest request,Model model,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "") String recivename){
        Emplyee emplyee = (Emplyee) request.getSession().getAttribute("emplyee");
        PageInfo<Message> pageInfo = messageService.getMessageList(pageNum, 3, recivename,0,emplyee.getId());
        model.addAttribute("pageInfo",pageInfo);
        return "messagerecive";
    }
}
