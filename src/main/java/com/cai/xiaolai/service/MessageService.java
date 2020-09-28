package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.Message;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageService {
    PageInfo<Message> getMessageList(int pageNum,int pageSize,String recivename,int sendId,int reciveId);

    void save(Message message);
}
