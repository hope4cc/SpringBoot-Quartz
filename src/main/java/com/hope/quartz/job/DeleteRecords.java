package com.hope.quartz.job;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.hope.quartz.Utils.SpringBeanUtils;
import com.hope.quartz.dto.JobAndTriggerDto;
import com.hope.quartz.service.Impl.RecordsServiceImpl;
import com.hope.quartz.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 文件名：DeleteRecords
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/22-11:36
 * 描述：
 */

/**
 * 使用Spring提供的Quartz相关Job类型实现Job的定义。
 * 父类型QuartzJobBean中，提供了分布式环境中任务的配置定义。
 * 保证分布式环境中的任务是有效的。
 */
@PersistJobDataAfterExecution
// 当job执行结束，持久化job信息到数据库
@DisallowConcurrentExecution
// 保证job的唯一性（单例）
@Slf4j
@Component
public class DeleteRecords extends QuartzJobBean {

    public static DeleteRecords DeleteRecords;

    @PostConstruct
    public void init() {
        DeleteRecords = this;
    }
    @Autowired
    private RecordsServiceImpl recordService;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            DeleteRecords.recordService.delete();
            log.info("调用任务成功,删除一年前的闸门出入记录");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("调用任务失败");
        }
        log.info("执行时间: " + DateUtil.now());
    }
}
