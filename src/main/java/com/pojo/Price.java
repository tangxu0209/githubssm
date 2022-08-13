package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private String priceid;// 生成主键编号
    private String cateid;// 农产品类型
    private String goodsid;// 农产品
    private String price;// 价格
    private String addtime;// 日期
    private String catename;// 映射数据
    private String goodsname;// 映射数据
}
