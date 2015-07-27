package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;
import com.letv.tigase.manager.TigPubsubAffiliationsManager;
import com.letv.tigase.service.TigPubsubAffiliationsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubAffiliationsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubAffiliationsServiceImpl implements TigPubsubAffiliationsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubAffiliationsServiceImpl.class);

    @Autowired
    private TigPubsubAffiliationsManager tigPubsubAffiliationsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.batchInsert")
    public boolean insert(List<TigPubsubAffiliations> tigPubsubAffiliationsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubAffiliationsList)) {
                resultFlag = tigPubsubAffiliationsManager.insert(tigPubsubAffiliationsList);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.insert")
    public boolean insert(TigPubsubAffiliations tigPubsubAffiliations) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubAffiliations) {
                if (tigPubsubAffiliationsManager.exist(tigPubsubAffiliations)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubAffiliationsManager.insert(tigPubsubAffiliations);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubAffiliationsServiceImpl#insert failed, tigPubsubAffiliations has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.update")
    public boolean update(TigPubsubAffiliations tigPubsubAffiliations) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubAffiliations && null != tigPubsubAffiliations.getJidId()) {
                resultFlag = tigPubsubAffiliationsManager.update(tigPubsubAffiliations);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.queryTigPubsubAffiliationsList")
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsList(TigPubsubAffiliationsQuery queryBean) {
        List<TigPubsubAffiliations> tigPubsubAffiliationsList = null;
        try {
            tigPubsubAffiliationsList = tigPubsubAffiliationsManager.queryTigPubsubAffiliationsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#queryTigPubsubAffiliationsList has error.", e);
        }
        return tigPubsubAffiliationsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.queryTigPubsubAffiliationsListWithPage")
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsListWithPage(TigPubsubAffiliationsQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubAffiliations> tigPubsubAffiliationsList = null;
        try {
            tigPubsubAffiliationsList = tigPubsubAffiliationsManager.queryTigPubsubAffiliationsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#queryTigPubsubAffiliationsListWithPage has error.", e);
        }
        return tigPubsubAffiliationsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.delete")
    public boolean delete(TigPubsubAffiliations tigPubsubAffiliations) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubAffiliations && null != tigPubsubAffiliations.getJidId()) {
                resultFlag = tigPubsubAffiliationsManager.delete(tigPubsubAffiliations);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.batchDelete")
    public boolean delete(TigPubsubAffiliations[] tigPubsubAffiliationss) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubAffiliationss && tigPubsubAffiliationss.length > 0) {
                resultFlag = tigPubsubAffiliationsManager.delete(tigPubsubAffiliationss);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubAffiliationsService.getTigPubsubAffiliationsById")
    public TigPubsubAffiliations getTigPubsubAffiliationsById(Long id) {
        TigPubsubAffiliations tigPubsubAffiliations = null;
        try {
            if (null != id) {
                tigPubsubAffiliations = tigPubsubAffiliationsManager.getTigPubsubAffiliationsById(id);
            } else {
                LOG.warn("TigPubsubAffiliationsServiceImpl#getTigPubsubAffiliationsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubAffiliationsServiceImpl#getTigPubsubAffiliationsById has error.", e);
        }
        return tigPubsubAffiliations;
    }
}

