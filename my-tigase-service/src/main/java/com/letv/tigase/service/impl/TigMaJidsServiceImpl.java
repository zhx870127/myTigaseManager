package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;
import com.letv.tigase.manager.TigMaJidsManager;
import com.letv.tigase.service.TigMaJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigMaJidsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigMaJidsServiceImpl implements TigMaJidsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigMaJidsServiceImpl.class);

    @Autowired
    private TigMaJidsManager tigMaJidsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.batchInsert")
    public boolean insert(List<TigMaJids> tigMaJidsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigMaJidsList)) {
                resultFlag = tigMaJidsManager.insert(tigMaJidsList);
            } else {
                LOG.warn("TigMaJidsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.insert")
    public boolean insert(TigMaJids tigMaJids) {
        boolean resultFlag = false;
        try {
            if (null != tigMaJids) {
                if (tigMaJidsManager.exist(tigMaJids)) {
                    throw new ExistedException();
                }
                resultFlag = tigMaJidsManager.insert(tigMaJids);
            } else {
                LOG.warn("TigMaJidsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigMaJidsServiceImpl#insert failed, tigMaJids has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.update")
    public boolean update(TigMaJids tigMaJids) {
        boolean resultFlag = false;
        try {
            if (null != tigMaJids && null != tigMaJids.getJidId()) {
                resultFlag = tigMaJidsManager.update(tigMaJids);
            } else {
                LOG.warn("TigMaJidsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.queryTigMaJidsList")
    public List<TigMaJids> queryTigMaJidsList(TigMaJidsQuery queryBean) {
        List<TigMaJids> tigMaJidsList = null;
        try {
            tigMaJidsList = tigMaJidsManager.queryTigMaJidsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#queryTigMaJidsList has error.", e);
        }
        return tigMaJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.queryTigMaJidsListWithPage")
    public List<TigMaJids> queryTigMaJidsListWithPage(TigMaJidsQuery queryBean, PageUtil pageUtil) {
        List<TigMaJids> tigMaJidsList = null;
        try {
            tigMaJidsList = tigMaJidsManager.queryTigMaJidsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#queryTigMaJidsListWithPage has error.", e);
        }
        return tigMaJidsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.delete")
    public boolean delete(TigMaJids tigMaJids) {
        boolean resultFlag = false;
        try {
            if (null != tigMaJids && null != tigMaJids.getJidId()) {
                resultFlag = tigMaJidsManager.delete(tigMaJids);
            } else {
                LOG.warn("TigMaJidsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.batchDelete")
    public boolean delete(TigMaJids[] tigMaJidss) {
        boolean resultFlag = false;
        try {
            if (null != tigMaJidss && tigMaJidss.length > 0) {
                resultFlag = tigMaJidsManager.delete(tigMaJidss);
            } else {
                LOG.warn("TigMaJidsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaJidsService.getTigMaJidsById")
    public TigMaJids getTigMaJidsById(Long id) {
        TigMaJids tigMaJids = null;
        try {
            if (null != id) {
                tigMaJids = tigMaJidsManager.getTigMaJidsById(id);
            } else {
                LOG.warn("TigMaJidsServiceImpl#getTigMaJidsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaJidsServiceImpl#getTigMaJidsById has error.", e);
        }
        return tigMaJids;
    }
}

