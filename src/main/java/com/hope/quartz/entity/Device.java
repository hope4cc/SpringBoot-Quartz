package com.hope.quartz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件名：Device
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-16:00
 * 描述：闸门
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private int id;
    private String name;
    private String location;
    private String state;
}