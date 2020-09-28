package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

    List<Message> getMessageList(@Param("recivename") String recivename,@Param("sendId") int sendId,@Param("reciveId") int reciveId);

    void save(@Param("message") Message message);
}
