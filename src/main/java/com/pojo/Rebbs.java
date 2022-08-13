package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rebbs {
    private String rebbsid;// 生成主键编号
    private String usersid;// 回复人
    private String bbsid;// 留言
    private String contents;// 内容
    private String addtime;// 回复日期
    private String username;// 映射数据
    private String title;// 映射数据
    private String image;
}
