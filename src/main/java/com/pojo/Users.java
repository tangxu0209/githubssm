package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String usersid;// 生成主键编号
    private String username;// 用户名
    private String password;// 密码
    private String realname;// 姓名
    private String sex;// 性别
    private String birthday;// 出生日期
    private String contact;// 联系方式
    private String address;// 联系地址
    private String image;// 头像
    private String role;// 角色
    private String status;// 状态
    private String regdate;// 注册日期
}
