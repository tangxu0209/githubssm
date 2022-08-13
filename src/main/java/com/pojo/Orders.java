package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String ordersid;// 生成主键编号
    private String ordercode;// 订单号
    private String usersid;// 采购人
    private String goodsid;// 水果
    private String price;// 单价
    private String num;// 数量
    private String total;// 总计
    private String addtime;// 下单日期
    private String status;// 状态
    private String username;// 映射数据
    private String goodsname;// 映射数据
    private String sellerid;
}
