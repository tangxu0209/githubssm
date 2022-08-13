package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banner {
    private String bannerid;// 生成主键编号
    private String bannername;// 菜品名称
    private String addtime;// 创建日期
    private String memo;// 备注
}
