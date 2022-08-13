package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private String adminid ;// 生成主键编号
    private String username;// 用户名
    private String password;// 密码
    private String realname;// 姓名
    private String contact;// 联系方式
    private String addtime;// 创建日期
}
