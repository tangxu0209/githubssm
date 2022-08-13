package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String goodsid;// 生成主键编号
    private String usersid;// 发布人
    private String goodsname;// 水果名称
    private String image;// 图片
    private String cateid;// 水果类型
    private String price;// 销售单价
    private String storage;// 库存数量
    private String addtime;// 发布日期
    private String hits;// 点击数
    private String sellnum;// 销量
    private String contents;// 水果详情
    private String username;// 映射数据
    private String catename;// 映射数据
}
