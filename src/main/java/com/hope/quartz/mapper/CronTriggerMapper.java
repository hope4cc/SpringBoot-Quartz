package com.hope.quartz.mapper;


import com.hope.quartz.entity.quartz.CronTrigger;
import com.hope.quartz.entity.quartz.CronTriggerKey;
import org.springframework.stereotype.Repository;

@Repository
public interface CronTriggerMapper {
    int deleteByPrimaryKey(CronTriggerKey key);

    int insert(CronTrigger record);

    int insertSelective(CronTrigger record);

    CronTrigger selectByPrimaryKey(CronTriggerKey key);

    int updateByPrimaryKeySelective(CronTrigger record);

    int updateByPrimaryKey(CronTrigger record);
}