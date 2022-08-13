package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cate {
    private String cateid;// 生成主键编号
    private String catename;// 类型名称
    private String memo;// 备注
    private List<Goods> goodsList = new ArrayList<Goods>();
}
