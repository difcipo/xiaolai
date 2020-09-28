package com.cai.xiaolai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emplyee {
    private Integer id;
    private String number;//编号
    private String username;
    private String password;
    private String emil;
    private String phone;
    private Integer sex;
    private Integer state;
    private Integer departId;
    private Integer roleId;
    private Department department;
    private Role role;


}
