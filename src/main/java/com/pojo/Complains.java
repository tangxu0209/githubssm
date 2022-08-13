package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complains {
    private String complainsid;// 生成主键编号
    private String usersid;// 发布人
    private String title;// 标题
    private String contents;// 内容
    private String addtime;// 发布日期
    private String status;// 状态
    private String reps;// 管理员回复
    private String username;// 映射数据
}
