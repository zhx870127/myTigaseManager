package com.letv.tigase.schedule.service.impl;

import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.letv.schedule.task.BusinessService;
import com.letv.schedule.task.domain.Task;

/**
 * 测试 任务
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
@Service("testTaskService")
public class TestTaskService implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTaskService.class);

    @Profiled(tag = "TestTaskService.executeSingleTask")
    public boolean executeSingleTask(final Task task, final String ownSign) throws Exception {
        LOGGER.info("TestTaskService do something: id" + task.getTaskId());

        return true;
    }

}
