package com.hope.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * 文件名：MyJob
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/20-21:13
 * 描述：Quartz简单使用案例
 */

@DisallowConcurrentExecution
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

            System.out.println("我被成功触发拉（每分钟秒钟） -----> MyJob execute ---->" + new Date());


    }
    public static void main(String[] args) throws Exception {
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1").build();
        // 创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group3")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 * * * ?"))
                .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        // 调度器开始调度任务
        scheduler.start();
    }


}