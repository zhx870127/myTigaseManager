package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
import com.letv.tigase.manager.TigPubsubServiceJidsManager;
import com.letv.tigase.service.TigPubsubServiceJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubServiceJidsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubServiceJidsServiceImpl implements TigPubsubServiceJidsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubServiceJidsServiceImpl.class);

    @Autowired
    private TigPubsubServiceJidsManager tigPubsubServiceJidsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.batchInsert")
    public boolean insert(List<TigPubsubServiceJids> tigPubsubServiceJidsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubServiceJidsList)) {
                resultFlag = tigPubsubServiceJidsManager.insert(tigPubsubServiceJidsList);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.insert")
    public boolean insert(TigPubsubServiceJids tigPubsubServiceJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubServiceJids) {
                if (tigPubsubServiceJidsManager.exist(tigPubsubServiceJids)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubServiceJidsManager.insert(tigPubsubServiceJids);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubServiceJidsServiceImpl#insert failed, tigPubsubServiceJids has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.update")
    public boolean update(TigPubsubServiceJids tigPubsubServiceJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubServiceJids && null != tigPubsubServiceJids.getServiceId()) {
                resultFlag = tigPubsubServiceJidsManager.update(tigPubsubServiceJids);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.queryTigPubsubServiceJidsList")
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsList(TigPubsubServiceJidsQuery queryBean) {
        List<TigPubsubServiceJids> tigPubsubServiceJidsList = null;
        try {
            tigPubsubServiceJidsList = tigPubsubServiceJidsManager.queryTigPubsubServiceJidsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#queryTigPubsubServiceJidsList has error.", e);
        }
        return tigPubsubServiceJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.queryTigPubsubServiceJidsListWithPage")
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsListWithPage(TigPubsubServiceJidsQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubServiceJids> tigPubsubServiceJidsList = null;
        try {
            tigPubsubServiceJidsList = tigPubsubServiceJidsManager.queryTigPubsubServiceJidsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#queryTigPubsubServiceJidsListWithPage has error.", e);
        }
        return tigPubsubServiceJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.delete")
    public boolean delete(TigPubsubServiceJids tigPubsubServiceJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubServiceJids && null != tigPubsubServiceJids.getServiceId()) {
                resultFlag = tigPubsubServiceJidsManager.delete(tigPubsubServiceJids);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.batchDelete")
    public boolean delete(TigPubsubServiceJids[] tigPubsubServiceJidss) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubServiceJidss && tigPubsubServiceJidss.length > 0) {
                resultFlag = tigPubsubServiceJidsManager.delete(tigPubsubServiceJidss);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubServiceJidsService.getTigPubsubServiceJidsById")
    public TigPubsubServiceJids getTigPubsubServiceJidsById(Long id) {
        TigPubsubServiceJids tigPubsubServiceJids = null;
        try {
            if (null != id) {
                tigPubsubServiceJids = tigPubsubServiceJidsManager.getTigPubsubServiceJidsById(id);
            } else {
                LOG.warn("TigPubsubServiceJidsServiceImpl#getTigPubsubServiceJidsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubServiceJidsServiceImpl#getTigPubsubServiceJidsById has error.", e);
        }
        return tigPubsubServiceJids;
    }
}

