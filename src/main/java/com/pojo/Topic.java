package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private String topicid;// 生成主键编号
    private String usersid;// 用户
    private String ordersid;// 订单
    private String goodsid;// 水果
    private String num;// 评分
    private String contents;// 内容
    private String addtime;// 日期
    private String username;// 映射数据
    private String ordercode;// 映射数据
    private String goodsname;// 映射数据
}
