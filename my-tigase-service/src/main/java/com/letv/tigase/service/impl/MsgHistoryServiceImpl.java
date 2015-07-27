package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
import com.letv.tigase.manager.MsgHistoryManager;
import com.letv.tigase.service.MsgHistoryService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * MsgHistoryService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class MsgHistoryServiceImpl implements MsgHistoryService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(MsgHistoryServiceImpl.class);

    @Autowired
    private MsgHistoryManager msgHistoryManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.batchInsert")
    public boolean insert(List<MsgHistory> msgHistoryList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(msgHistoryList)) {
                resultFlag = msgHistoryManager.insert(msgHistoryList);
            } else {
                LOG.warn("MsgHistoryServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.insert")
    public boolean insert(MsgHistory msgHistory) {
        boolean resultFlag = false;
        try {
            if (null != msgHistory) {
                if (msgHistoryManager.exist(msgHistory)) {
                    throw new ExistedException();
                }
                resultFlag = msgHistoryManager.insert(msgHistory);
            } else {
                LOG.warn("MsgHistoryServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("MsgHistoryServiceImpl#insert failed, msgHistory has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.update")
    public boolean update(MsgHistory msgHistory) {
        boolean resultFlag = false;
        try {
            if (null != msgHistory && null != msgHistory.getMsgId()) {
                resultFlag = msgHistoryManager.update(msgHistory);
            } else {
                LOG.warn("MsgHistoryServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.queryMsgHistoryList")
    public List<MsgHistory> queryMsgHistoryList(MsgHistoryQuery queryBean) {
        List<MsgHistory> msgHistoryList = null;
        try {
            msgHistoryList = msgHistoryManager.queryMsgHistoryList(queryBean);
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#queryMsgHistoryList has error.", e);
        }
        return msgHistoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.queryMsgHistoryListWithPage")
    public List<MsgHistory> queryMsgHistoryListWithPage(MsgHistoryQuery queryBean, PageUtil pageUtil) {
        List<MsgHistory> msgHistoryList = null;
        try {
            msgHistoryList = msgHistoryManager.queryMsgHistoryListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#queryMsgHistoryListWithPage has error.", e);
        }
        return msgHistoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.delete")
    public boolean delete(MsgHistory msgHistory) {
        boolean resultFlag = false;
        try {
            if (null != msgHistory && null != msgHistory.getMsgId()) {
                resultFlag = msgHistoryManager.delete(msgHistory);
            } else {
                LOG.warn("MsgHistoryServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.batchDelete")
    public boolean delete(MsgHistory[] msgHistorys) {
        boolean resultFlag = false;
        try {
            if (null != msgHistorys && msgHistorys.length > 0) {
                resultFlag = msgHistoryManager.delete(msgHistorys);
            } else {
                LOG.warn("MsgHistoryServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "MsgHistoryService.getMsgHistoryById")
    public MsgHistory getMsgHistoryById(Long id) {
        MsgHistory msgHistory = null;
        try {
            if (null != id) {
                msgHistory = msgHistoryManager.getMsgHistoryById(id);
            } else {
                LOG.warn("MsgHistoryServiceImpl#getMsgHistoryById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("MsgHistoryServiceImpl#getMsgHistoryById has error.", e);
        }
        return msgHistory;
    }
}

