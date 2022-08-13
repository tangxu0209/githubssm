package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
    private String articleid;// 生成主键编号
    private String title;// 标题
    private String bannerid;// 菜品
    private String image;// 图片
    private String contents;// 内容
    private String addtime;// 发布日期
    private String hits;// 点击数
    private String bannername;// 映射数据
}
