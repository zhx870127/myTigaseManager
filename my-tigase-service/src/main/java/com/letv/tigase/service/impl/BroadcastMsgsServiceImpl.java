package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
import com.letv.tigase.manager.BroadcastMsgsManager;
import com.letv.tigase.service.BroadcastMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * BroadcastMsgsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class BroadcastMsgsServiceImpl implements BroadcastMsgsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(BroadcastMsgsServiceImpl.class);

    @Autowired
    private BroadcastMsgsManager broadcastMsgsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.batchInsert")
    public boolean insert(List<BroadcastMsgs> broadcastMsgsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(broadcastMsgsList)) {
                resultFlag = broadcastMsgsManager.insert(broadcastMsgsList);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.insert")
    public boolean insert(BroadcastMsgs broadcastMsgs) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgs) {
                if (broadcastMsgsManager.exist(broadcastMsgs)) {
                    throw new ExistedException();
                }
                resultFlag = broadcastMsgsManager.insert(broadcastMsgs);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("BroadcastMsgsServiceImpl#insert failed, broadcastMsgs has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.update")
    public boolean update(BroadcastMsgs broadcastMsgs) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgs && null != broadcastMsgs.getId()) {
                resultFlag = broadcastMsgsManager.update(broadcastMsgs);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.queryBroadcastMsgsList")
    public List<BroadcastMsgs> queryBroadcastMsgsList(BroadcastMsgsQuery queryBean) {
        List<BroadcastMsgs> broadcastMsgsList = null;
        try {
            broadcastMsgsList = broadcastMsgsManager.queryBroadcastMsgsList(queryBean);
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#queryBroadcastMsgsList has error.", e);
        }
        return broadcastMsgsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.queryBroadcastMsgsListWithPage")
    public List<BroadcastMsgs> queryBroadcastMsgsListWithPage(BroadcastMsgsQuery queryBean, PageUtil pageUtil) {
        List<BroadcastMsgs> broadcastMsgsList = null;
        try {
            broadcastMsgsList = broadcastMsgsManager.queryBroadcastMsgsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#queryBroadcastMsgsListWithPage has error.", e);
        }
        return broadcastMsgsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.delete")
    public boolean delete(BroadcastMsgs broadcastMsgs) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgs && null != broadcastMsgs.getId()) {
                resultFlag = broadcastMsgsManager.delete(broadcastMsgs);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.batchDelete")
    public boolean delete(BroadcastMsgs[] broadcastMsgss) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgss && broadcastMsgss.length > 0) {
                resultFlag = broadcastMsgsManager.delete(broadcastMsgss);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsService.getBroadcastMsgsById")
    public BroadcastMsgs getBroadcastMsgsById(String id) {
        BroadcastMsgs broadcastMsgs = null;
        try {
            if (null != id) {
                broadcastMsgs = broadcastMsgsManager.getBroadcastMsgsById(id);
            } else {
                LOG.warn("BroadcastMsgsServiceImpl#getBroadcastMsgsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsServiceImpl#getBroadcastMsgsById has error.", e);
        }
        return broadcastMsgs;
    }
}

