package com.letv.test.tigase.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;
import com.letv.tigase.service.TigNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.test.base.BaseTransactionTestCase;
import com.letv.test.base.TestConstants;

/**
 * TigNodesService单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
public class TigNodesServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TigNodesService tigNodesService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        Long parentNid = null; //TODO 初始化
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        tigNodes.setUid(uid);
        tigNodes.setCreateUser(TestConstants.UER_NAME);
        boolean result = tigNodesService.insert(tigNodes);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        Long parentNid = null; //TODO 初始化// 已经存在的
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化// 已经存在的
        tigNodes.setUid(uid);
        tigNodes.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tigNodesService.insert(tigNodes);
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
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        tigNodes.setId(TEST_DEFAULT_EXIST_ID);
        Long parentNid = null; //TODO 初始化
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        tigNodes.setUid(uid);
        tigNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigNodesService.delete(tigNodes);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        tigNodes.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long parentNid = null; //TODO 初始化
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        tigNodes.setUid(uid);
        tigNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigNodesService.delete(tigNodes);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        tigNodes.setId(TEST_DEFAULT_EXIST_ID);
        Long parentNid = null; //TODO 初始化
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        tigNodes.setUid(uid);
        tigNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigNodesService.update(tigNodes);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tigNodesService);
        TigNodes tigNodes = new TigNodes();
        tigNodes.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long parentNid = null; //TODO 初始化
        tigNodes.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        tigNodes.setUid(uid);
        tigNodes.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tigNodesService.update(tigNodes);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tigNodesService);
        TigNodes c = tigNodesService.getTigNodesById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tigNodesService);
        TigNodes c = tigNodesService.getTigNodesById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tigNodesService);
        TigNodesQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TigNodes> list = tigNodesService.queryTigNodesListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tigNodesService);
        TigNodesQuery queryBean = new TigNodesQuery();
        Long parentNid = null; //TODO 初始化
        queryBean.setParentNid(parentNid);
        Long uid = null; //TODO 初始化
        queryBean.setUid(uid);
        List<TigNodes> list = tigNodesService.queryTigNodesList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
