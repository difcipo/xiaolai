package com.cai.xiaolai.service.impl;


import com.cai.xiaolai.entity.Message;
import com.cai.xiaolai.mapper.MessageMapper;
import com.cai.xiaolai.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public PageInfo<Message> getMessageList(int pageNum,int pageSize,String recivename,int sendId,int reciveId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Message> messageList = messageMapper.getMessageList(recivename,sendId,reciveId);
        PageInfo<Message> pageInfo = new PageInfo<>(messageList);
        return pageInfo;
    }

    @Override
    public void save(Message message) {
        messageMapper.save(message);
    }
}
