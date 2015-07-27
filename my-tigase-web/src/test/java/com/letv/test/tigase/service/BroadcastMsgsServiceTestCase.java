package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
import com.letv.tigase.service.BroadcastMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * BroadcastMsgsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class BroadcastMsgsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private BroadcastMsgsService broadcastMsgsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        Date expired = null; //TODO 初始化
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setCreateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsService.insert(broadcastMsgs);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        Date expired = null; //TODO 初始化// 已经存在的
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化// 已经存在的
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = broadcastMsgsService.insert(broadcastMsgs);
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
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        broadcastMsgs.setId(TEST_DEFAULT_EXIST_ID);
        Date expired = null; //TODO 初始化
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsService.delete(broadcastMsgs);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        broadcastMsgs.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Date expired = null; //TODO 初始化
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsService.delete(broadcastMsgs);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        broadcastMsgs.setId(TEST_DEFAULT_EXIST_ID);
        Date expired = null; //TODO 初始化
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsService.update(broadcastMsgs);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs broadcastMsgs = new BroadcastMsgs();
        broadcastMsgs.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Date expired = null; //TODO 初始化
        broadcastMsgs.setExpired(expired);
        String msg = null; //TODO 初始化
        broadcastMsgs.setMsg(msg);
        broadcastMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsService.update(broadcastMsgs);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs c = broadcastMsgsService.getBroadcastMsgsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgs c = broadcastMsgsService.getBroadcastMsgsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<BroadcastMsgs> list = broadcastMsgsService.queryBroadcastMsgsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(broadcastMsgsService);
        BroadcastMsgsQuery queryBean = new BroadcastMsgsQuery();
        Date expired = null; //TODO 初始化
        queryBean.setExpired(expired);
        String msg = null; //TODO 初始化
        queryBean.setMsg(msg);
        List<BroadcastMsgs> list = broadcastMsgsService.queryBroadcastMsgsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
