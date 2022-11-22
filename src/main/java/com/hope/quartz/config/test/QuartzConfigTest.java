package com.hope.quartz.config.test;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 文件名：QuartzConfig
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-16:49
 * 描述：定时器
 */
@Component
public class QuartzConfigTest {




    /**
     * 创建定时任务
     */
    @Bean
    public JobDetail quartzTestDetail() {
        JobDetail jobDetail = JobBuilder.newJob(QuartzTestJob.class)
                .withIdentity("quartzTestDetail", "QUARTZ_TEST")
                .usingJobData("quartz", "我被成功触发拉（每5秒钟)"+new Date())
                .storeDurably()
                .build();
        return jobDetail;
    }

    /**
     * 创建触发器
     */
    @Bean
    public Trigger quartzTestJobTrigger() {
        //每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        //创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(quartzTestDetail())
                .withIdentity("quartzTestJobTrigger", "QUARTZ_TEST_JOB_TRIGGER")
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;
    }





//    private UserMapper userMapper;
//
//    public QuartzConfig(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//
////    //测试 每隔一秒查询所有用户
////    @Scheduled(cron = "0/1 * * * * ?")
////    public void  test() {
////        List<User> allUser = userMapper.getAllUser();
////        System.out.println(allUser);
////    }





}
