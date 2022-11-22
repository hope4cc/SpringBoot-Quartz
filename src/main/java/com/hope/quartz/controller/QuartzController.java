package com.hope.quartz.controller;

import com.github.pagehelper.PageInfo;
import com.hope.quartz.comon.RespBean;
import com.hope.quartz.comon.ResponseCode;
import com.hope.quartz.dto.JobAndTriggerDto;
import com.hope.quartz.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：QuartzController
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-23:01
 * 描述：
 */
@Slf4j
@RestController
@RequestMapping("/quartz")
public class QuartzController {
    @Autowired
    public QuartzController(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    private QuartzService quartzService;

    /**
     * 新增定时任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/addjob")
    @ResponseBody
    public RespBean addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            quartzService.addjob(jName, jGroup, tName, tGroup, cron);
            return new RespBean(ResponseCode.SUCCESS,"添加任务成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespBean(ResponseCode.ERROR,"添加任务失败");
        }
    }



    /**
     * 暂停任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/pausejob")
    @ResponseBody
    public RespBean pausejob(String jName, String jGroup) {
        try {
            quartzService.pausejob(jName, jGroup);
            return new RespBean(ResponseCode.SUCCESS,"暂停任务成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new RespBean(ResponseCode.ERROR,"暂停任务失败");
        }
    }
    /**
     * 恢复任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/resumejob")
    @ResponseBody
    public RespBean resumejob(String jName, String jGroup) {
        try {
            quartzService.resumejob(jName, jGroup);
            return new RespBean(ResponseCode.SUCCESS,"恢复任务成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new RespBean(ResponseCode.ERROR,"恢复任务失败");
        }
    }

    /**
     * 重启任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param cron cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/reschedulejob")
    @ResponseBody
    public RespBean rescheduleJob(String jName, String jGroup, String cron) {
        try {
            quartzService.rescheduleJob(jName, jGroup, cron);
            return new RespBean(ResponseCode.SUCCESS,"重启任务成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new RespBean(ResponseCode.ERROR,"重启任务失败");
        }
    }

    /**
     * 删除任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/deletejob")
    @ResponseBody
    public RespBean deletejob(String jName, String jGroup) {
        try {
            quartzService.deletejob(jName, jGroup);
            return new RespBean(ResponseCode.SUCCESS,"删除任务成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new RespBean(ResponseCode.ERROR,"删除任务失败");
        }
    }

    /**
     * 查询任务
     *
     * @param pageNum 页码
     * @param pageSize 每页显示多少条数据
     * @return Map
     */
    @GetMapping(path = "/queryjob")
    @ResponseBody
    public RespBean queryjob(Integer pageNum, Integer pageSize) {
        PageInfo<JobAndTriggerDto> pageInfo = quartzService.getJobAndTriggerDetails(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(pageInfo.getTotal())) {
            map.put("JobAndTrigger", pageInfo);
            map.put("number", pageInfo.getTotal());
            return new RespBean(ResponseCode.SUCCESS,map,"查询任务成功");
        }
        return new RespBean(ResponseCode.ERROR,"查询任务成功失败，没有数据");
    }

}
