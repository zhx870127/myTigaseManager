package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
import com.letv.tigase.service.TigMaMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigMaMsgsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigMaMsgsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigMaMsgsService tigMaMsgsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        Long ownerId = null; //TODO 初始化
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigMaMsgsService.insert(tigMaMsgs);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        Long ownerId = null; //TODO 初始化// 已经存在的
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化// 已经存在的
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigMaMsgsService.insert(tigMaMsgs);
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
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        tigMaMsgs.setId(TEST_DEFAULT_EXIST_ID);
        Long ownerId = null; //TODO 初始化
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigMaMsgsService.delete(tigMaMsgs);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        tigMaMsgs.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long ownerId = null; //TODO 初始化
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigMaMsgsService.delete(tigMaMsgs);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        tigMaMsgs.setId(TEST_DEFAULT_EXIST_ID);
        Long ownerId = null; //TODO 初始化
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigMaMsgsService.update(tigMaMsgs);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs tigMaMsgs = new TigMaMsgs();
        tigMaMsgs.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long ownerId = null; //TODO 初始化
        tigMaMsgs.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        tigMaMsgs.setBuddyId(buddyId);
        tigMaMsgs.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigMaMsgsService.update(tigMaMsgs);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs c = tigMaMsgsService.getTigMaMsgsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgs c = tigMaMsgsService.getTigMaMsgsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigMaMsgs> list = tigMaMsgsService.queryTigMaMsgsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigMaMsgsService);
        TigMaMsgsQuery queryBean = new TigMaMsgsQuery();
        Long ownerId = null; //TODO 初始化
        queryBean.setOwnerId(ownerId);
        Long buddyId = null; //TODO 初始化
        queryBean.setBuddyId(buddyId);
        List<TigMaMsgs> list = tigMaMsgsService.queryTigMaMsgsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
