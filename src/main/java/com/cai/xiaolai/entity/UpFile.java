package com.cai.xiaolai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpFile {
    private Integer id;
    private String title;
    private String upTime;
    private String describe;
    private Emplyee emplyee;
}
