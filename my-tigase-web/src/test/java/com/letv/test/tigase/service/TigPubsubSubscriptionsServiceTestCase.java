package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
import com.letv.tigase.service.TigPubsubSubscriptionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigPubsubSubscriptionsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigPubsubSubscriptionsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigPubsubSubscriptionsService tigPubsubSubscriptionsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        Long jidId = null; //TODO 初始化
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubSubscriptionsService.insert(tigPubsubSubscriptions);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        Long jidId = null; //TODO 初始化// 已经存在的
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化// 已经存在的
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigPubsubSubscriptionsService.insert(tigPubsubSubscriptions);
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
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        tigPubsubSubscriptions.setId(TEST_DEFAULT_EXIST_ID);
        Long jidId = null; //TODO 初始化
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubSubscriptionsService.delete(tigPubsubSubscriptions);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        tigPubsubSubscriptions.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long jidId = null; //TODO 初始化
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubSubscriptionsService.delete(tigPubsubSubscriptions);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        tigPubsubSubscriptions.setId(TEST_DEFAULT_EXIST_ID);
        Long jidId = null; //TODO 初始化
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubSubscriptionsService.update(tigPubsubSubscriptions);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions tigPubsubSubscriptions = new TigPubsubSubscriptions();
        tigPubsubSubscriptions.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long jidId = null; //TODO 初始化
        tigPubsubSubscriptions.setJidId(jidId);
        String subscription = null; //TODO 初始化
        tigPubsubSubscriptions.setSubscription(subscription);
        tigPubsubSubscriptions.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubSubscriptionsService.update(tigPubsubSubscriptions);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions c = tigPubsubSubscriptionsService.getTigPubsubSubscriptionsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptions c = tigPubsubSubscriptionsService.getTigPubsubSubscriptionsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptionsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigPubsubSubscriptions> list = tigPubsubSubscriptionsService.queryTigPubsubSubscriptionsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigPubsubSubscriptionsService);
        TigPubsubSubscriptionsQuery queryBean = new TigPubsubSubscriptionsQuery();
        Long jidId = null; //TODO 初始化
        queryBean.setJidId(jidId);
        String subscription = null; //TODO 初始化
        queryBean.setSubscription(subscription);
        List<TigPubsubSubscriptions> list = tigPubsubSubscriptionsService.queryTigPubsubSubscriptionsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
