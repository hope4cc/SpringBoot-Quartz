package com.hope.quartz.dto;

import lombok.Data;

import java.math.BigInteger;

/**
 * 文件名：JobAndTriggerDto
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-22:45
 * 描述：
 */
@Data
public class JobAndTriggerDto {
    private String JOB_NAME;

    private String JOB_GROUP;

    private String JOB_CLASS_NAME;

    private String TRIGGER_NAME;

    private String TRIGGER_GROUP;

    private BigInteger REPEAT_INTERVAL;

    private BigInteger TIMES_TRIGGERED;

    private String CRON_EXPRESSION;

    private String TIME_ZONE_ID;
}
