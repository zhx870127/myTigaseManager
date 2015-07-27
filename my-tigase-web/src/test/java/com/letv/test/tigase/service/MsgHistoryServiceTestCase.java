package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
import com.letv.tigase.service.MsgHistoryService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * MsgHistoryService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class MsgHistoryServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private MsgHistoryService msgHistoryService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        Date ts = null; //TODO 初始化
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化
        msgHistory.setExpired(expired);
        msgHistory.setCreateUser(TestConstants.UER_NAME);
        boolean result = msgHistoryService.insert(msgHistory);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        Date ts = null; //TODO 初始化// 已经存在的
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化// 已经存在的
        msgHistory.setExpired(expired);
        msgHistory.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = msgHistoryService.insert(msgHistory);
            Assert.isTrue(!result);
        } catch (ExistedException e) {
            ex = e;
        }
        Assert.notNull(ex);
    }

    /**
     * 测试删除数据-成功
     */
    @Test
    public void testDelete() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        msgHistory.setId(TEST_DEFAULT_EXIST_ID);
        Date ts = null; //TODO 初始化
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化
        msgHistory.setExpired(expired);
        msgHistory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = msgHistoryService.delete(msgHistory);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        msgHistory.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Date ts = null; //TODO 初始化
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化
        msgHistory.setExpired(expired);
        msgHistory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = msgHistoryService.delete(msgHistory);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        msgHistory.setId(TEST_DEFAULT_EXIST_ID);
        Date ts = null; //TODO 初始化
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化
        msgHistory.setExpired(expired);
        msgHistory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = msgHistoryService.update(msgHistory);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(msgHistoryService);
        MsgHistory msgHistory = new MsgHistory();
        msgHistory.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Date ts = null; //TODO 初始化
        msgHistory.setTs(ts);
        Date expired = null; //TODO 初始化
        msgHistory.setExpired(expired);
        msgHistory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = msgHistoryService.update(msgHistory);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(msgHistoryService);
        MsgHistory c = msgHistoryService.getMsgHistoryById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(msgHistoryService);
        MsgHistory c = msgHistoryService.getMsgHistoryById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(msgHistoryService);
        MsgHistoryQuery queryBean = null;
        PageUtil pageUtil = null;
        List<MsgHistory> list = msgHistoryService.queryMsgHistoryListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(msgHistoryService);
        MsgHistoryQuery queryBean = new MsgHistoryQuery();
        Date ts = null; //TODO 初始化
        queryBean.setTs(ts);
        Date expired = null; //TODO 初始化
        queryBean.setExpired(expired);
        List<MsgHistory> list = msgHistoryService.queryMsgHistoryList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
