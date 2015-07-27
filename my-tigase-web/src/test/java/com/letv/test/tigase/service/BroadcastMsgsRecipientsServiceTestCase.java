package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
import com.letv.tigase.service.BroadcastMsgsRecipientsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * BroadcastMsgsRecipientsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class BroadcastMsgsRecipientsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private BroadcastMsgsRecipientsService broadcastMsgsRecipientsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        Long jidId = null; //TODO 初始化
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setCreateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsRecipientsService.insert(broadcastMsgsRecipients);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        Long jidId = null; //TODO 初始化// 已经存在的
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = broadcastMsgsRecipientsService.insert(broadcastMsgsRecipients);
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
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        broadcastMsgsRecipients.setId(TEST_DEFAULT_EXIST_ID);
        Long jidId = null; //TODO 初始化
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsRecipientsService.delete(broadcastMsgsRecipients);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        broadcastMsgsRecipients.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long jidId = null; //TODO 初始化
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsRecipientsService.delete(broadcastMsgsRecipients);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        broadcastMsgsRecipients.setId(TEST_DEFAULT_EXIST_ID);
        Long jidId = null; //TODO 初始化
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsRecipientsService.update(broadcastMsgsRecipients);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients broadcastMsgsRecipients = new BroadcastMsgsRecipients();
        broadcastMsgsRecipients.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long jidId = null; //TODO 初始化
        broadcastMsgsRecipients.setJidId(jidId);
        broadcastMsgsRecipients.setUpdateUser(TestConstants.UER_NAME);
        boolean result = broadcastMsgsRecipientsService.update(broadcastMsgsRecipients);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients c = broadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipients c = broadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipientsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<BroadcastMsgsRecipients> list = broadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(broadcastMsgsRecipientsService);
        BroadcastMsgsRecipientsQuery queryBean = new BroadcastMsgsRecipientsQuery();
        Long jidId = null; //TODO 初始化
        queryBean.setJidId(jidId);
        List<BroadcastMsgsRecipients> list = broadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
