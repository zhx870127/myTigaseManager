package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
import com.letv.tigase.manager.BroadcastMsgsRecipientsManager;
import com.letv.tigase.service.BroadcastMsgsRecipientsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * BroadcastMsgsRecipientsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class BroadcastMsgsRecipientsServiceImpl implements BroadcastMsgsRecipientsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(BroadcastMsgsRecipientsServiceImpl.class);

    @Autowired
    private BroadcastMsgsRecipientsManager broadcastMsgsRecipientsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.batchInsert")
    public boolean insert(List<BroadcastMsgsRecipients> broadcastMsgsRecipientsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(broadcastMsgsRecipientsList)) {
                resultFlag = broadcastMsgsRecipientsManager.insert(broadcastMsgsRecipientsList);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.insert")
    public boolean insert(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgsRecipients) {
                if (broadcastMsgsRecipientsManager.exist(broadcastMsgsRecipients)) {
                    throw new ExistedException();
                }
                resultFlag = broadcastMsgsRecipientsManager.insert(broadcastMsgsRecipients);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("BroadcastMsgsRecipientsServiceImpl#insert failed, broadcastMsgsRecipients has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.update")
    public boolean update(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgsRecipients && null != broadcastMsgsRecipients.getJidId()) {
                resultFlag = broadcastMsgsRecipientsManager.update(broadcastMsgsRecipients);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsList")
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsList(BroadcastMsgsRecipientsQuery queryBean) {
        List<BroadcastMsgsRecipients> broadcastMsgsRecipientsList = null;
        try {
            broadcastMsgsRecipientsList = broadcastMsgsRecipientsManager.queryBroadcastMsgsRecipientsList(queryBean);
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#queryBroadcastMsgsRecipientsList has error.", e);
        }
        return broadcastMsgsRecipientsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsListWithPage")
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsListWithPage(BroadcastMsgsRecipientsQuery queryBean, PageUtil pageUtil) {
        List<BroadcastMsgsRecipients> broadcastMsgsRecipientsList = null;
        try {
            broadcastMsgsRecipientsList = broadcastMsgsRecipientsManager.queryBroadcastMsgsRecipientsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#queryBroadcastMsgsRecipientsListWithPage has error.", e);
        }
        return broadcastMsgsRecipientsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.delete")
    public boolean delete(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgsRecipients && null != broadcastMsgsRecipients.getJidId()) {
                resultFlag = broadcastMsgsRecipientsManager.delete(broadcastMsgsRecipients);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.batchDelete")
    public boolean delete(BroadcastMsgsRecipients[] broadcastMsgsRecipientss) {
        boolean resultFlag = false;
        try {
            if (null != broadcastMsgsRecipientss && broadcastMsgsRecipientss.length > 0) {
                resultFlag = broadcastMsgsRecipientsManager.delete(broadcastMsgsRecipientss);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BroadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById")
    public BroadcastMsgsRecipients getBroadcastMsgsRecipientsById(Long id) {
        BroadcastMsgsRecipients broadcastMsgsRecipients = null;
        try {
            if (null != id) {
                broadcastMsgsRecipients = broadcastMsgsRecipientsManager.getBroadcastMsgsRecipientsById(id);
            } else {
                LOG.warn("BroadcastMsgsRecipientsServiceImpl#getBroadcastMsgsRecipientsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BroadcastMsgsRecipientsServiceImpl#getBroadcastMsgsRecipientsById has error.", e);
        }
        return broadcastMsgsRecipients;
    }
}

