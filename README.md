# 一、概述
:::warning
模拟 定时删除不用的数据。如删除一年前的门禁进出记录
:::

```sql
#闸门表
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

BEGIN;
INSERT INTO `device` VALUES (2, 'west_1_in', '西门-1号闸机-出', 'stop');
INSERT INTO `device` VALUES (3, 'face_recognition', '南门-1号闸机-入', 'stop');
INSERT INTO `device` VALUES (5, 'east_1_out', '东门-1号闸机-出', 'stop');
COMMIT;

#进出记录表
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) unsigned DEFAULT NULL,
  `did` int(11) unsigned DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8mb4;



BEGIN;
INSERT INTO `records` VALUES (71, 21303206,3, '2021-05-26 10:04:43');
INSERT INTO `records` VALUES (72, 21303206,3, '2021-05-26 10:04:54');
INSERT INTO `records` VALUES (73, 21303206,3, '2021-05-26 10:05:01');
INSERT INTO `records` VALUES (74, 21303206,3, '2021-05-26 10:05:20');
INSERT INTO `records` VALUES (75, 21303206,3, '2021-05-26 10:05:50');
INSERT INTO `records` VALUES (76, 21303206,3, '2021-05-26 10:05:55');
INSERT INTO `records` VALUES (77, 21303206,3, '2021-05-26 10:06:39');
INSERT INTO `records` VALUES (78, 21303206,3, '2021-05-26 10:06:40');
INSERT INTO `records` VALUES (79, 21303206,3, '2021-05-26 10:07:03');
INSERT INTO `records` VALUES (80, 21303206,3, '2021-05-28 15:06:54');
INSERT INTO `records` VALUES (81, 21303206,3, '2021-05-28 15:06:58');
INSERT INTO `records` VALUES (82, 21303206,3, '2021-05-28 15:07:09');
INSERT INTO `records` VALUES (83, 21303206,3, '2021-05-28 15:07:22');
INSERT INTO `records` VALUES (84, 21303206,3, '2021-05-28 15:07:30');
INSERT INTO `records` VALUES (85, 21303206,3, '2021-05-28 15:07:34');
INSERT INTO `records` VALUES (86, 21303206,3, '2021-05-28 15:07:38');
INSERT INTO `records` VALUES (87, 21303206,3, '2021-06-03 16:44:22');
INSERT INTO `records` VALUES (88, 21303206,3, '2021-06-03 16:44:26');
INSERT INTO `records` VALUES (89, 21303206,3, '2021-06-03 16:44:35');
INSERT INTO `records` VALUES (90, 21303206,3, '2021-06-03 16:44:59');
INSERT INTO `records` VALUES (91, 21303206,3, '2021-06-03 16:45:03');
INSERT INTO `records` VALUES (92, 21303206,3, '2021-06-03 16:45:07');
INSERT INTO `records` VALUES (93, 21303206,3, '2021-06-03 16:45:17');
INSERT INTO `records` VALUES (110,21303206, 3, '2021-06-05 08:51:35');
INSERT INTO `records` VALUES (111,21303206, 3, '2021-06-05 08:51:45');
INSERT INTO `records` VALUES (112,21303206, 3, '2021-06-05 08:51:59');
INSERT INTO `records` VALUES (113,21303206, 3, '2021-06-05 08:53:18');
INSERT INTO `records` VALUES (114,21303206, 3, '2021-06-05 09:08:08');
INSERT INTO `records` VALUES (115,21303206, 3, '2021-06-05 09:13:51');
INSERT INTO `records` VALUES (116,21303206, 3, '2021-06-05 09:16:42');
INSERT INTO `records` VALUES (117,21303206, 3, '2021-06-05 09:16:50');
INSERT INTO `records` VALUES (118,21303206, 3, '2021-06-05 09:17:44');
INSERT INTO `records` VALUES (119, 21303201, 3, '2021-06-05 09:19:15');
INSERT INTO `records` VALUES (120, 21303201, 3, '2021-06-08 19:45:35');
INSERT INTO `records` VALUES (121, 21303201, 3, '2021-06-08 19:45:39');
INSERT INTO `records` VALUES (122, 21303201, 3, '2021-06-08 19:45:43');
INSERT INTO `records` VALUES (123, 21303201, 3, '2021-06-08 19:45:47');
INSERT INTO `records` VALUES (124, 21303201, 3, '2021-06-08 19:45:51');
INSERT INTO `records` VALUES (125, 21303201, 3, '2021-06-08 19:45:55');
INSERT INTO `records` VALUES (126, 21303201, 3, '2021-06-08 19:45:59');
INSERT INTO `records` VALUES (127, 21303201, 3, '2021-06-08 19:46:03');
INSERT INTO `records` VALUES (128, 21303201, 3, '2021-06-08 19:46:07');
INSERT INTO `records` VALUES (129, 21303201, 3, '2021-06-08 19:46:23');
INSERT INTO `records` VALUES (130, 21303201, 3, '2021-06-08 19:46:29');
INSERT INTO `records` VALUES (131, 21303201, 3, '2021-06-08 19:46:55');
INSERT INTO `records` VALUES (132, 21303201, 3, '2021-06-08 19:46:59');
INSERT INTO `records` VALUES (133, 21303201, 3, '2021-06-08 19:47:03');
INSERT INTO `records` VALUES (134, 21303201, 3, '2021-06-08 19:47:07');
COMMIT;

#用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `flag` int(1) DEFAULT '0' COMMENT '注销标志，1:注销,0:正常',
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

BEGIN;
INSERT INTO `user` VALUES (21303201, '菜菜',1);
INSERT INTO `user` VALUES (21303202, '苏苏',1);
COMMIT;

```
:::warning
**quartz包含的主要接口如下：**

Scheduler 代表调度容器，一个调度容器中可以注册多个JobDetail和Trigger。
Job 代表工作，即要执行的具体内容。
JobDetail 代表具体的可执行的调度程序，Job是这个可执行程调度程序所要执行的内容。
JobBuilder 用于定义或构建JobDetail实例。
Trigger 代表调度触发器，决定什么时候去调。
TriggerBuilder 用于定义或构建触发器。
JobStore 用于存储作业和任务调度期间的状态。
:::
# 二、Springboot 整合 Quartz
### 1、数据库表准备
#### 1.1、Quartz 的作业存储类型

RAMJobStore：
RAM 也就是内存，默认情况下 Quartz 会将任务调度存储在内存中，这种方式性能是最好的，因为内存的速度是最快的。不好的地方就是数据缺乏持久性，但程序崩溃或者重新发布的时候，所有运行信息都会丢失
JDBC 作业存储：
存到数据库之后，可以做单点也可以做集群，当任务多了之后，可以统一进行管理，随时停止、暂停、修改任务。关闭或者重启服务器，运行的信息都不会丢失。缺点就是运行速度快慢取决于连接数据库的快慢

Quartz 存储任务信息有两种方式，使用内存或者使用数据库来存储，这里我采用 MySQL 数据库存储的方式，首先需要新建 Quartz 的相关表
sql 脚本下载地址：[http://www.quartz-scheduler.org/downloads/](http://www.quartz-scheduler.org/downloads/)，名称为 tables_mysql.sql
创建成功后数据库中多出 11 张表
![输入图片说明](images/%E8%A1%A8.pic.jpg)

#### 1.2、Maven 主要依赖
```xml
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.2.2</version>
        </dependency>
         <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
     
    	  <!--mysql-->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
    

        <!--quartz依赖-->
        <!-- https://mvnrepository.com/artifact/org.quartz-scheduler/quartz -->
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz</artifactId>
            <version>2.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz-jobs</artifactId>
            <version>2.3.2</version>
        </dependency>

        <!-- 集成redis依赖  -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

     	<!-- druid  -->
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid-spring-boot-starter -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.2.8</version>
        </dependency>


        <!--pagehelper分页-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!--hutool工具集-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.3.10</version>
        </dependency>
        <dependency>
            <groupId>org.jetbrains</groupId>
            <artifactId>annotations</artifactId>
            <version>13.0</version>
            <scope>compile</scope>
        </dependency>
```
:::warning
这里使用 druid 作为数据库连接池，Quartz 默认使用 c3p0
:::
### 2、配置文件
#### 2.1、quartz.properties
:::warning
默认情况下，Quartz 会加载 classpath 下的 quartz.properties 作为配置文件。如果找不到，则会使用 quartz 框架自己 jar 包下 org/quartz 底下的 quartz.properties 文件
:::
![输入图片说明](images/%E5%9B%BE%E7%89%871.jpg)
```properties
#主要分为scheduler、threadPool、jobStore、dataSource等部分


org.quartz.scheduler.instanceId=AUTO
org.quartz.scheduler.instanceName=MyQuartzScheduler
#如果您希望Quartz Scheduler通过RMI作为服务器导出本身，则将“rmi.export”标志设置为true
#在同一个配置文件中为'org.quartz.scheduler.rmi.export'和'org.quartz.scheduler.rmi.proxy'指定一个'true'值是没有意义的,如果你这样做'export'选项将被忽略
org.quartz.scheduler.rmi.export=false
#如果要连接（使用）远程服务的调度程序，则将“org.quartz.scheduler.rmi.proxy”标志设置为true。您还必须指定RMI注册表进程的主机和端口 - 通常是“localhost”端口1099
org.quartz.scheduler.rmi.proxy=false
org.quartz.scheduler.wrapJobExecutionInUserTransaction=false


#实例化ThreadPool时，使用的线程类为SimpleThreadPool
org.quartz.threadPool.class=org.quartz.simpl.SimpleThreadPool
#threadCount和threadPriority将以setter的形式注入ThreadPool实例
#并发个数  如果你只有几个工作每天触发几次 那么1个线程就可以,如果你有成千上万的工作，每分钟都有很多工作 那么久需要50-100之间.
#只有1到100之间的数字是非常实用的
org.quartz.threadPool.threadCount=5
#优先级 默认值为5
org.quartz.threadPool.threadPriority=5
#可以是“true”或“false”，默认为false
org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread=true


#在被认为“misfired”(失火)之前，调度程序将“tolerate(容忍)”一个Triggers(触发器)将其下一个启动时间通过的毫秒数。默认值（如果您在配置中未输入此属性）为60000（60秒）
org.quartz.jobStore.misfireThreshold=5000
# 默认存储在内存中,RAMJobStore快速轻便，但是当进程终止时，所有调度信息都会丢失
#org.quartz.jobStore.class=org.quartz.simpl.RAMJobStore

#持久化方式，默认存储在内存中，此处使用数据库方式
org.quartz.jobStore.class=org.quartz.impl.jdbcjobstore.JobStoreTX
#您需要为JobStore选择一个DriverDelegate才能使用。DriverDelegate负责执行特定数据库可能需要的任何JDBC工作
# StdJDBCDelegate是一个使用“vanilla”JDBC代码（和SQL语句）来执行其工作的委托,用于完全符合JDBC的驱动程序
org.quartz.jobStore.driverDelegateClass=org.quartz.impl.jdbcjobstore.StdJDBCDelegate
#可以将“org.quartz.jobStore.useProperties”配置参数设置为“true”（默认为false），以指示JDBCJobStore将JobDataMaps中的所有值都作为字符串，
#因此可以作为名称 - 值对存储而不是在BLOB列中以其序列化形式存储更多复杂的对象。从长远来看，这是更安全的，因为您避免了将非String类序列化为BLOB的类版本问题
org.quartz.jobStore.useProperties=true
#表前缀
org.quartz.jobStore.tablePrefix=QRTZ_
#数据源别名，自定义
org.quartz.jobStore.dataSource=qzDS


#使用阿里的druid作为数据库连接池
org.quartz.dataSource.qzDS.connectionProvider.class=com.hope.quartz.config.DruidPoolingconnectionProvider
org.quartz.dataSource.qzDS.URL=jdbc:mysql://127.0.0.1:3306/acs?characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=UTC
org.quartz.dataSource.qzDS.user=root
org.quartz.dataSource.qzDS.password=root
org.quartz.dataSource.qzDS.driver=com.mysql.cj.jdbc.Driver
org.quartz.dataSource.qzDS.maxConnections=10
#设置为“true”以打开群集功能。如果您有多个Quartz实例使用同一组数据库表，则此属性必须设置为“true”，否则您将遇到破坏
#org.quartz.jobStore.isClustered=false

```
#### 2.2、application.yaml
```yaml

server:
  ip: localhost
  port: 9000

#Spring
spring:
  main:
    allow-circular-references: true #因循环引用导致启动时报错的问题
  datasource:
    #1.JDBC
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/acs?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
    username: root
    password: root
    druid:
      #2.连接池配置
      #初始化连接池的连接数量 大小，最小，最大
      initial-size: 3
      min-idle: 3
      max-active: 10
      #配置获取连接等待超时的时间
      max-wait: 60000
  redis:
    host: 1.15.87.229
    port: 6379
    password: 123
    database: 1

mybatis:
  mapper-locations: classpath:mapper/*.xml #mybatis
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```
#### 2.3、quartz 配置类 QuartzConfig
```java
@Configuration
public class QuartzConfig implements SchedulerFactoryBeanCustomizer {

    @Bean
    public Properties properties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        // 对quartz.properties文件进行读取
        propertiesFactoryBean.setLocation(new ClassPathResource("/myquartz.properties"));
        // 在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setQuartzProperties(properties());
        return schedulerFactoryBean;
    }

    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

    /**
     * 使用阿里的druid作为数据库连接池
     */
    @Override
    public void customize(@NotNull SchedulerFactoryBean schedulerFactoryBean) {
        schedulerFactoryBean.setStartupDelay(2);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
    }
}

```
### 3、业务
#### 3.1、创建任务类
:::warning
这里模拟 定时删除不用的数据。如删除一年前的门禁进出记录
:::
:::warning
#### 删除一年前的数据
DELETE FROM  `records` where year(time)=year(date_sub(now(),interval 1 year));
:::
```java
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
```
#### 3.2、 Service 层
```java
package com.hope.quartz.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hope.quartz.dto.JobAndTriggerDto;
import com.hope.quartz.job.DeleteRecords;
//import com.hope.quartz.job.HelloJob;
import com.hope.quartz.mapper.JobDetailMapper;
import com.hope.quartz.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件名：QuartzServiceImpl
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-22:46
 * 描述：
 */
@Slf4j
@Service
public class QuartzServiceImpl implements QuartzService {


    private JobDetailMapper jobDetailMapper;
    private Scheduler scheduler;

    @Autowired
    public QuartzServiceImpl(JobDetailMapper jobDetailMapper, Scheduler scheduler) {
        this.jobDetailMapper = jobDetailMapper;
        this.scheduler = scheduler;
    }

    @Override
    public PageInfo<JobAndTriggerDto> getJobAndTriggerDetails(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobAndTriggerDto> list = jobDetailMapper.getJobAndTriggerDetails();
        PageInfo<JobAndTriggerDto> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 新增定时任务
     *
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    @Override
    public void addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            // 构建JobDetail
            JobDetail jobDetail = JobBuilder.newJob(DeleteRecords.class)
                    .withIdentity(jName, jGroup)
                    .build();
            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(tName, tGroup)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            // 启动调度器
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.info("创建定时任务失败" + e);
        }
    }


    @Override
    public void pausejob(String jName, String jGroup) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jName, jGroup));
    }

    @Override
    public void resumejob(String jName, String jGroup) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jName, jGroup));
    }

    @Override
    public void rescheduleJob(String jName, String jGroup, String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jName, jGroup);
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行，重启触发器
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    @Override
    public void deletejob(String jName, String jGroup) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jName, jGroup));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jName, jGroup));
        scheduler.deleteJob(JobKey.jobKey(jName, jGroup));
    }

}

```
#### 3.3、Controller 层
```java
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

```
#### 3.4、接口测试
#### 3.4.1、新增定时任务
postman 测试如下
为了测试方便，cron选择5秒钟执行一次
![输入图片说明](images/postman.jpg)
![输入图片说明](images/%E6%B5%8B%E8%AF%951.jpg)
![输入图片说明](images/%E6%B5%8B%E8%AF%952.jpg)
# 三、其他
### 1、cron表达式
```
//cron表达式的用法；
//秒 分 时 日 月 周几
//0  * *  *  * MON-FRI

结构
corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份

工具:https://cron.qqe2.com/

常用的表达式   
（1）0/2 * * * * ?   表示每2秒 执行任务
（1）0 0/2 * * * ?   表示每2分钟 执行任务
（1）0 0 2 1 * ?   表示在每月的1日的凌晨2点调整任务
（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作
（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点
（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
（6）0 0 12 ? * WED   表示每个星期三中午12点
（7）0 0 12 * * ?   每天中午12点触发
（8）0 15 10 ? * *   每天上午10:15触发
（9）0 15 10 * * ?     每天上午10:15触发
（10）0 15 10 * * ?   每天上午10:15触发
（11）0 15 10 * * ? 2005   2005年的每天上午10:15触发
（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发
（13）0 0/5 14 * * ?   在每天下午2点到下午2:55期间的每5分钟触发
（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
（15）0 0-5 14 * * ?   在每天下午2点到下午2:05期间的每1分钟触发
（16）0 10,44 14 ? 3 WED   每年三月的星期三的下午2:10和2:44触发
（17）0 15 10 ? * MON-FRI   周一至周五的上午10:15触发
（18）0 15 10 15 * ?   每月15日上午10:15触发
（19）0 15 10 L * ?   每月最后一日的上午10:15触发
（20）0 15 10 ? * 6L   每月的最后一个星期五上午10:15触发
（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发
（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
```
### 2、触发内容
每1小时触发一次定时器：控制台输出内容“我被成功触发拉（每1小时）” **0 0 /1 * * ? **
每2分钟触发一次定时器：控制台输出内容“我被成功触发拉（每2分钟）”**0 0/2 * * * ?**
每5秒钟触发一次定时器：控制台输出内容“我被成功触发拉（每5秒钟）” **0/5 * * * * ?**
每天凌晨1：30触发一次定时器：控制台输出内容“我被成功触发拉（凌晨1:30) **0 30 1 * * ?**
#### Spring自带的定时器 spring task
:::warning
优点：spring框架自带的定时功能，springboot做了非常好的封装，开启和定义定时任务非常容易，支持复杂的 cron 表达式，可以满足绝大多数单机版的业务场景。单个任务时，当前次的调度完成后，再执行下一次任务调度。
缺点：默认单线程，如果前面的任务执行时间太长，对后面任务的执行有影响。不支持集群方式部署，不能做数据存储型定时任务。
:::
```java
    /**
     *      Spring自带的定时器
	 *		启动类上需要加入注解@EnableScheduling
     *      import org.springframework.scheduling.annotation.Scheduled;
     */
	//每1小时触发一次定时器：控制台输出内容“我被成功触发拉（每1小时）” 
    @Scheduled(cron = "0 30 1 * * ?")
    public void  Everyday() {
        String format= goDateTime(new Date());
        System.out.println("我被成功触发拉（凌晨1：30）"+format);
    }

 	//测试 控制台输出内容“我被成功触发拉（每2分钟）”
    @Scheduled(cron = "0 0/2 * * * ?")
    public void  testTwoMinutes() {
        String format= goDateTime(new Date());
        System.out.println("我被成功触发拉（每2分钟）"+format);
    }

    //测试 每隔5秒触发一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void  testFiveSeconds() {
        String format= goDateTime(new Date());
        System.out.println("我被成功触发拉（每5秒钟）"+format);
    }

    //每天凌晨1:30触发一次定时器：控制台输出内容“我被成功触发拉（凌晨1：30）
    @Scheduled(cron = "0 30 1 * * ?")
    public void  Everyday() {
        String format= goDateTime(new Date());
        System.out.println("我被成功触发拉（凌晨1：30）"+format);
    }

	

    //日期格式
    public static  String goDateTime(Date datetime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String thisDateTime = df.format(datetime);
        return  thisDateTime;
    }
```
![输入图片说明](images/%E5%9B%BE%E7%89%872.png)

#### springboot 集成 quartz 
:::warning
使用 spring quartz 的优缺点：
优点：默认是多线程异步执行，单个任务时，在上一个调度未完成时，下一个调度时间到时，会另起一个线程开始新的调度，多个任务之间互不影响。支持复杂的 cron 表达式，它能被集群实例化，支持分布式部署。
缺点：相对于spring task实现定时任务成本更高，需要手动配置 QuartzJobBean 、 JobDetail和 Trigger 等。需要引入了第三方的 quartz 包，有一定的学习成本。不支持并行调度，不支持失败处理策略和动态分片的策略等。
:::
pom.xml文件中引入 quartz 相关依赖。
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-quartz</artifactId>
</dependency>
```
```java
创建真正的定时任务执行类，该类继承 QuartzJobBean 。
public class QuartzTestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String quartzValue = (String) context.getJobDetail().getJobDataMap().get("quartz");
        System.out.println("quartz:" + quartzValue);

    }
}

创建调度程序 JobDetail 和调度器 Trigger 。
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
    //每隔5秒执行一次 spring quartz 跟 spring task 的 cron 表达式规则基本一致
    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

    //创建触发器
    Trigger trigger = TriggerBuilder.newTrigger()
        .forJob(quartzTestDetail())
        .withIdentity("quartzTestJobTrigger", "QUARTZ_TEST_JOB_TRIGGER")
        .withSchedule(cronScheduleBuilder)
        .build();
    return trigger;
}
```
# 四、遇到的问题解决
### 非spring管理的工具类使用@Autowired注解注入DAO为null的问题
:::warning
使用**@Component**注解将工具类声明为spring组件，并**静态初始化**。
:::
```java

    //静态初始化 
    public static DeleteRecords DeleteRecords;
	//保证Bean初始化前已经装配了属性
    @PostConstruct
    public void init() {
        DeleteRecords = this;
    }
    @Autowired
    private RecordsServiceImpl recordService;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            DeleteRecords.recordService.delete();//使用
            log.info("调用任务成功,删除一年前的闸门出入记录");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("调用任务失败");
        }
        log.info("执行时间: " + DateUtil.now());
    }
```
### Active Scheduler of name 'MyClusterScheduler' already registered in Quartz SchedulerRepository.
:::warning
工程里面我的quartz的配置文件名为quartz.properties，跟Quartz默认的配置文件名quartz.properties相同。导致工程启动的时候，我本地的quartz配置文件覆盖了系统的配置文件。
解决[https://blog.csdn.net/Nancy50/article/details/104017171](https://blog.csdn.net/Nancy50/article/details/104017171)
:::
