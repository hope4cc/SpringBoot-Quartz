package com.hope.quartz.service.Impl;

import com.hope.quartz.entity.Records;
import com.hope.quartz.mapper.RecordsMapper;
import com.hope.quartz.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件名：RecordsServiceImpl
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/22-12:06
 * 描述：
 */
@Service
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsMapper recordsMapper;

    @Override
    public void delete() {
        recordsMapper.delete();

    }
}
