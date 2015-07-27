package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
import com.letv.tigase.manager.TigPubsubSubscriptionsManager;
import com.letv.tigase.service.TigPubsubSubscriptionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubSubscriptionsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubSubscriptionsServiceImpl implements TigPubsubSubscriptionsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubSubscriptionsServiceImpl.class);

    @Autowired
    private TigPubsubSubscriptionsManager tigPubsubSubscriptionsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.batchInsert")
    public boolean insert(List<TigPubsubSubscriptions> tigPubsubSubscriptionsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubSubscriptionsList)) {
                resultFlag = tigPubsubSubscriptionsManager.insert(tigPubsubSubscriptionsList);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.insert")
    public boolean insert(TigPubsubSubscriptions tigPubsubSubscriptions) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubSubscriptions) {
                if (tigPubsubSubscriptionsManager.exist(tigPubsubSubscriptions)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubSubscriptionsManager.insert(tigPubsubSubscriptions);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubSubscriptionsServiceImpl#insert failed, tigPubsubSubscriptions has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.update")
    public boolean update(TigPubsubSubscriptions tigPubsubSubscriptions) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubSubscriptions && null != tigPubsubSubscriptions.getJidId()) {
                resultFlag = tigPubsubSubscriptionsManager.update(tigPubsubSubscriptions);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.queryTigPubsubSubscriptionsList")
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsList(TigPubsubSubscriptionsQuery queryBean) {
        List<TigPubsubSubscriptions> tigPubsubSubscriptionsList = null;
        try {
            tigPubsubSubscriptionsList = tigPubsubSubscriptionsManager.queryTigPubsubSubscriptionsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#queryTigPubsubSubscriptionsList has error.", e);
        }
        return tigPubsubSubscriptionsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.queryTigPubsubSubscriptionsListWithPage")
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsListWithPage(TigPubsubSubscriptionsQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubSubscriptions> tigPubsubSubscriptionsList = null;
        try {
            tigPubsubSubscriptionsList = tigPubsubSubscriptionsManager.queryTigPubsubSubscriptionsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#queryTigPubsubSubscriptionsListWithPage has error.", e);
        }
        return tigPubsubSubscriptionsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.delete")
    public boolean delete(TigPubsubSubscriptions tigPubsubSubscriptions) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubSubscriptions && null != tigPubsubSubscriptions.getJidId()) {
                resultFlag = tigPubsubSubscriptionsManager.delete(tigPubsubSubscriptions);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.batchDelete")
    public boolean delete(TigPubsubSubscriptions[] tigPubsubSubscriptionss) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubSubscriptionss && tigPubsubSubscriptionss.length > 0) {
                resultFlag = tigPubsubSubscriptionsManager.delete(tigPubsubSubscriptionss);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubSubscriptionsService.getTigPubsubSubscriptionsById")
    public TigPubsubSubscriptions getTigPubsubSubscriptionsById(Long id) {
        TigPubsubSubscriptions tigPubsubSubscriptions = null;
        try {
            if (null != id) {
                tigPubsubSubscriptions = tigPubsubSubscriptionsManager.getTigPubsubSubscriptionsById(id);
            } else {
                LOG.warn("TigPubsubSubscriptionsServiceImpl#getTigPubsubSubscriptionsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubSubscriptionsServiceImpl#getTigPubsubSubscriptionsById has error.", e);
        }
        return tigPubsubSubscriptions;
    }
}

