package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;
import com.letv.tigase.service.TigPubsubJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigPubsubJidsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigPubsubJidsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigPubsubJidsService tigPubsubJidsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        String jid = null; //TODO 初始化
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubJidsService.insert(tigPubsubJids);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        String jid = null; //TODO 初始化// 已经存在的
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化// 已经存在的
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigPubsubJidsService.insert(tigPubsubJids);
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
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        tigPubsubJids.setId(TEST_DEFAULT_EXIST_ID);
        String jid = null; //TODO 初始化
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubJidsService.delete(tigPubsubJids);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        tigPubsubJids.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String jid = null; //TODO 初始化
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubJidsService.delete(tigPubsubJids);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        tigPubsubJids.setId(TEST_DEFAULT_EXIST_ID);
        String jid = null; //TODO 初始化
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubJidsService.update(tigPubsubJids);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids tigPubsubJids = new TigPubsubJids();
        tigPubsubJids.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String jid = null; //TODO 初始化
        tigPubsubJids.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        tigPubsubJids.setJidSha1(jidSha1);
        tigPubsubJids.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubJidsService.update(tigPubsubJids);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids c = tigPubsubJidsService.getTigPubsubJidsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJids c = tigPubsubJidsService.getTigPubsubJidsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJidsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigPubsubJids> list = tigPubsubJidsService.queryTigPubsubJidsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigPubsubJidsService);
        TigPubsubJidsQuery queryBean = new TigPubsubJidsQuery();
        String jid = null; //TODO 初始化
        queryBean.setJid(jid);
        String jidSha1 = null; //TODO 初始化
        queryBean.setJidSha1(jidSha1);
        List<TigPubsubJids> list = tigPubsubJidsService.queryTigPubsubJidsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
