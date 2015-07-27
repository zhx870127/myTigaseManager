package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
import com.letv.tigase.service.TigSocks5ConnectionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigSocks5ConnectionsService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigSocks5ConnectionsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigSocks5ConnectionsService tigSocks5ConnectionsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        Long uid = null; //TODO 初始化
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigSocks5ConnectionsService.insert(tigSocks5Connections);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        Long uid = null; //TODO 初始化// 已经存在的
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化// 已经存在的
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigSocks5ConnectionsService.insert(tigSocks5Connections);
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
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        tigSocks5Connections.setId(TEST_DEFAULT_EXIST_ID);
        Long uid = null; //TODO 初始化
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigSocks5ConnectionsService.delete(tigSocks5Connections);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        tigSocks5Connections.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long uid = null; //TODO 初始化
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigSocks5ConnectionsService.delete(tigSocks5Connections);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        tigSocks5Connections.setId(TEST_DEFAULT_EXIST_ID);
        Long uid = null; //TODO 初始化
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigSocks5ConnectionsService.update(tigSocks5Connections);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections tigSocks5Connections = new TigSocks5Connections();
        tigSocks5Connections.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long uid = null; //TODO 初始化
        tigSocks5Connections.setUid(uid);
        String instance = null; //TODO 初始化
        tigSocks5Connections.setInstance(instance);
        tigSocks5Connections.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigSocks5ConnectionsService.update(tigSocks5Connections);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections c = tigSocks5ConnectionsService.getTigSocks5ConnectionsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5Connections c = tigSocks5ConnectionsService.getTigSocks5ConnectionsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5ConnectionsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigSocks5Connections> list = tigSocks5ConnectionsService.queryTigSocks5ConnectionsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigSocks5ConnectionsService);
        TigSocks5ConnectionsQuery queryBean = new TigSocks5ConnectionsQuery();
        Long uid = null; //TODO 初始化
        queryBean.setUid(uid);
        String instance = null; //TODO 初始化
        queryBean.setInstance(instance);
        List<TigSocks5Connections> list = tigSocks5ConnectionsService.queryTigSocks5ConnectionsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
