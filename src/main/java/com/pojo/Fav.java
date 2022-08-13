package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fav {
    private String favid;// 生成主键编号
    private String usersid;// 用户
    private String goodsid;// 水果
    private String addtime;// 收藏日期
    private String username;// 映射数据
    private String goodsname;// 映射数据
    private String image;
    private String price;
}
