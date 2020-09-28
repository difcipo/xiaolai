package com.cai.xiaolai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacate {
    private Integer id;
    private String number;
    private String vacateTime;
    private String startTime;
    private String endTime;
    private Integer state;

}
