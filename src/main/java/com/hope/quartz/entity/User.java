package com.hope.quartz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件名：User
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-15:58
 * 描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private int flag;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
}