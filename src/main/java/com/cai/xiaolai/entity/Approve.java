package com.cai.xiaolai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Approve {
    private Integer id;
    private String applyTitle;
    private String appleTime;
    private String applyName;
    private String approver; //审批人
    private String approveTime;
    private Integer state;

}
