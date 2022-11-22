package com.hope.quartz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件名：Records
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-15:59
 * 描述：记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Records {
    private int id;
    private int uid;
    private int did;
    private String time;
}