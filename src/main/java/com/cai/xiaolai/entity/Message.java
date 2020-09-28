package com.cai.xiaolai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String number;
    private String content;
    private Emplyee reciveName;
    private Integer reciveId;
    private Emplyee sendName;
    private String sendTime;
    private String reciveTime;
    private Integer state;

}
