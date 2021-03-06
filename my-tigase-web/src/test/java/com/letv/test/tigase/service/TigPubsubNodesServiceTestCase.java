package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
import com.letv.tigase.service.TigPubsubNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigPubsubNodesService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigPubsubNodesServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigPubsubNodesService tigPubsubNodesService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        Long serviceId = null; //TODO 初始化
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubNodesService.insert(tigPubsubNodes);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        Long serviceId = null; //TODO 初始化// 已经存在的
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化// 已经存在的
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigPubsubNodesService.insert(tigPubsubNodes);
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
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        tigPubsubNodes.setId(TEST_DEFAULT_EXIST_ID);
        Long serviceId = null; //TODO 初始化
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubNodesService.delete(tigPubsubNodes);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        tigPubsubNodes.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long serviceId = null; //TODO 初始化
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubNodesService.delete(tigPubsubNodes);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        tigPubsubNodes.setId(TEST_DEFAULT_EXIST_ID);
        Long serviceId = null; //TODO 初始化
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubNodesService.update(tigPubsubNodes);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes tigPubsubNodes = new TigPubsubNodes();
        tigPubsubNodes.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long serviceId = null; //TODO 初始化
        tigPubsubNodes.setServiceId(serviceId);
        String name = null; //TODO 初始化
        tigPubsubNodes.setName(name);
        tigPubsubNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigPubsubNodesService.update(tigPubsubNodes);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes c = tigPubsubNodesService.getTigPubsubNodesById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodes c = tigPubsubNodesService.getTigPubsubNodesById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodesQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigPubsubNodes> list = tigPubsubNodesService.queryTigPubsubNodesListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigPubsubNodesService);
        TigPubsubNodesQuery queryBean = new TigPubsubNodesQuery();
        Long serviceId = null; //TODO 初始化
        queryBean.setServiceId(serviceId);
        String name = null; //TODO 初始化
        queryBean.setName(name);
        List<TigPubsubNodes> list = tigPubsubNodesService.queryTigPubsubNodesList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
