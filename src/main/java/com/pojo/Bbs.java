package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bbs {
    private String bbsid;// 生成主键编号
    private String usersid;// 发布人
    private String title;// 标题
    private String contents;// 内容
    private String addtime;// 发布日期
    private String hits;// 点击数
    private String repnum;// 回复数
    private String username;// 映射数据
    private String image;
}
