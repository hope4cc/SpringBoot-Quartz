package com.hope.quartz.service;

import com.github.pagehelper.PageInfo;
import com.hope.quartz.dto.JobAndTriggerDto;
import org.quartz.SchedulerException;

/**
 * 文件名：QuartzService
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-22:44
 * 描述：
 */
public interface QuartzService {
    PageInfo<JobAndTriggerDto> getJobAndTriggerDetails(Integer pageNum, Integer pageSize);

    void addjob(String jName, String jGroup, String tName, String tGroup, String cron);

    void pausejob(String jName, String jGroupe) throws SchedulerException;

    void resumejob(String jName, String jGroup) throws SchedulerException;

    void rescheduleJob(String jName, String jGroup, String cron) throws SchedulerException;

    void deletejob(String jName, String jGroup) throws SchedulerException;
}
