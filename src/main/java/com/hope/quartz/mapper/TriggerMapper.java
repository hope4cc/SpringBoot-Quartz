package com.hope.quartz.mapper;


import com.hope.quartz.entity.quartz.Trigger;
import com.hope.quartz.entity.quartz.TriggerKey;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerMapper {
    int deleteByPrimaryKey(TriggerKey key);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(TriggerKey key);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKeyWithBLOBs(Trigger record);

    int updateByPrimaryKey(Trigger record);
}