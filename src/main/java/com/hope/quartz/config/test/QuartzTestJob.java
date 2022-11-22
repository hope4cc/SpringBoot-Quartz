package com.hope.quartz.config.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 文件名：QuartzTestJob
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-18:25
 * 描述：
 */
public class QuartzTestJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String quartzValue = (String) context.getJobDetail().getJobDataMap().get("quartz");
        System.out.println("quartz:" + quartzValue);

    }
}
