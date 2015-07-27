package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
import com.letv.tigase.service.TigPubsubServiceJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigPubsubServiceJidsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigPubsubServiceJidsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigPubsubServiceJidsService tigPubsubServiceJidsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        String serviceJid = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubServiceJidsService.insert(tigPubsubServiceJids);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        String serviceJid = null; //TODO 初始化// 已经存在的
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化// 已经存在的
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigPubsubServiceJidsService.insert(tigPubsubServiceJids);
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
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        tigPubsubServiceJids.setId(TEST_DEFAULT_EXIST_ID);
        String serviceJid = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubServiceJidsService.delete(tigPubsubServiceJids);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        tigPubsubServiceJids.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String serviceJid = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubServiceJidsService.delete(tigPubsubServiceJids);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        tigPubsubServiceJids.setId(TEST_DEFAULT_EXIST_ID);
        String serviceJid = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubServiceJidsService.update(tigPubsubServiceJids);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids tigPubsubServiceJids = new TigPubsubServiceJids();
        tigPubsubServiceJids.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String serviceJid = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        tigPubsubServiceJids.setServiceJidSha1(serviceJidSha1);
        tigPubsubServiceJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubServiceJidsService.update(tigPubsubServiceJids);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids c = tigPubsubServiceJidsService.getTigPubsubServiceJidsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJids c = tigPubsubServiceJidsService.getTigPubsubServiceJidsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJidsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigPubsubServiceJids> list = tigPubsubServiceJidsService.queryTigPubsubServiceJidsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigPubsubServiceJidsService);
        TigPubsubServiceJidsQuery queryBean = new TigPubsubServiceJidsQuery();
        String serviceJid = null; //TODO 初始化
        queryBean.setServiceJid(serviceJid);
        String serviceJidSha1 = null; //TODO 初始化
        queryBean.setServiceJidSha1(serviceJidSha1);
        List<TigPubsubServiceJids> list = tigPubsubServiceJidsService.queryTigPubsubServiceJidsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
