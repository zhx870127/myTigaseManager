package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;
import com.letv.tigase.manager.TigPubsubJidsManager;
import com.letv.tigase.service.TigPubsubJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubJidsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubJidsServiceImpl implements TigPubsubJidsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubJidsServiceImpl.class);

    @Autowired
    private TigPubsubJidsManager tigPubsubJidsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.batchInsert")
    public boolean insert(List<TigPubsubJids> tigPubsubJidsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubJidsList)) {
                resultFlag = tigPubsubJidsManager.insert(tigPubsubJidsList);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.insert")
    public boolean insert(TigPubsubJids tigPubsubJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubJids) {
                if (tigPubsubJidsManager.exist(tigPubsubJids)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubJidsManager.insert(tigPubsubJids);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubJidsServiceImpl#insert failed, tigPubsubJids has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.update")
    public boolean update(TigPubsubJids tigPubsubJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubJids && null != tigPubsubJids.getJidId()) {
                resultFlag = tigPubsubJidsManager.update(tigPubsubJids);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.queryTigPubsubJidsList")
    public List<TigPubsubJids> queryTigPubsubJidsList(TigPubsubJidsQuery queryBean) {
        List<TigPubsubJids> tigPubsubJidsList = null;
        try {
            tigPubsubJidsList = tigPubsubJidsManager.queryTigPubsubJidsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#queryTigPubsubJidsList has error.", e);
        }
        return tigPubsubJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.queryTigPubsubJidsListWithPage")
    public List<TigPubsubJids> queryTigPubsubJidsListWithPage(TigPubsubJidsQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubJids> tigPubsubJidsList = null;
        try {
            tigPubsubJidsList = tigPubsubJidsManager.queryTigPubsubJidsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#queryTigPubsubJidsListWithPage has error.", e);
        }
        return tigPubsubJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.delete")
    public boolean delete(TigPubsubJids tigPubsubJids) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubJids && null != tigPubsubJids.getJidId()) {
                resultFlag = tigPubsubJidsManager.delete(tigPubsubJids);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.batchDelete")
    public boolean delete(TigPubsubJids[] tigPubsubJidss) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubJidss && tigPubsubJidss.length > 0) {
                resultFlag = tigPubsubJidsManager.delete(tigPubsubJidss);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubJidsService.getTigPubsubJidsById")
    public TigPubsubJids getTigPubsubJidsById(Long id) {
        TigPubsubJids tigPubsubJids = null;
        try {
            if (null != id) {
                tigPubsubJids = tigPubsubJidsManager.getTigPubsubJidsById(id);
            } else {
                LOG.warn("TigPubsubJidsServiceImpl#getTigPubsubJidsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubJidsServiceImpl#getTigPubsubJidsById has error.", e);
        }
        return tigPubsubJids;
    }
}

