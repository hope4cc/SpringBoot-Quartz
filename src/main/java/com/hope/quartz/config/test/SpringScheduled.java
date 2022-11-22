package com.hope.quartz.config.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：Spring
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-18:18
 * 描述：
 */
@Component
public class SpringScheduled {
    public static  String goDateTime(Date datetime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String thisDateTime = df.format(datetime);
        return  thisDateTime;
    }

    /**
     *      Spring自带的定时器
     *      import org.springframework.scheduling.annotation.Scheduled;
     */
    //测试 每隔5秒触发一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void  testFiveSeconds() {
        String format= goDateTime(new Date());
        System.out.println("Spring我被成功触发拉（每5秒钟）"+format);
    }

    //测试 控制台输出内容“我被成功触发拉（每2分钟）”
    @Scheduled(cron = "0 0/2 * * * ?")
    public void  testTwoMinutes() {
        String format= goDateTime(new Date());
        System.out.println("Spring 我被成功触发拉（每2分钟）"+format);
    }

    //每天凌晨1:30触发一次定时器：控制台输出内容“我被成功触发拉（凌晨1：30）
    @Scheduled(cron = "0 30 1 * * ?")
    public void  Everyday() {
        String format= goDateTime(new Date());
        System.out.println("Spring 我被成功触发拉（凌晨1：30）"+format);
    }
}
