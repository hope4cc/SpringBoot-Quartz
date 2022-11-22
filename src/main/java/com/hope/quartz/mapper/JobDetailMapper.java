package com.hope.quartz.mapper;

import com.hope.quartz.dto.JobAndTriggerDto;
import com.hope.quartz.entity.quartz.JobDetail;
import com.hope.quartz.entity.quartz.JobDetailKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JobDetailMapper {
    int deleteByPrimaryKey(JobDetailKey key);

    int insert(JobDetail record);

    int insertSelective(JobDetail record);

    JobDetail selectByPrimaryKey(JobDetailKey key);

    int updateByPrimaryKeySelective(JobDetail record);

    int updateByPrimaryKeyWithBLOBs(JobDetail record);

    int updateByPrimaryKey(JobDetail record);

    List<JobAndTriggerDto> getJobAndTriggerDetails();
}