package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;
import com.letv.tigase.manager.TigNodesManager;
import com.letv.tigase.service.TigNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigNodesService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigNodesServiceImpl implements TigNodesService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigNodesServiceImpl.class);

    @Autowired
    private TigNodesManager tigNodesManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.batchInsert")
    public boolean insert(List<TigNodes> tigNodesList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigNodesList)) {
                resultFlag = tigNodesManager.insert(tigNodesList);
            } else {
                LOG.warn("TigNodesServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.insert")
    public boolean insert(TigNodes tigNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigNodes) {
                if (tigNodesManager.exist(tigNodes)) {
                    throw new ExistedException();
                }
                resultFlag = tigNodesManager.insert(tigNodes);
            } else {
                LOG.warn("TigNodesServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigNodesServiceImpl#insert failed, tigNodes has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.update")
    public boolean update(TigNodes tigNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigNodes && null != tigNodes.getNid()) {
                resultFlag = tigNodesManager.update(tigNodes);
            } else {
                LOG.warn("TigNodesServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.queryTigNodesList")
    public List<TigNodes> queryTigNodesList(TigNodesQuery queryBean) {
        List<TigNodes> tigNodesList = null;
        try {
            tigNodesList = tigNodesManager.queryTigNodesList(queryBean);
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#queryTigNodesList has error.", e);
        }
        return tigNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.queryTigNodesListWithPage")
    public List<TigNodes> queryTigNodesListWithPage(TigNodesQuery queryBean, PageUtil pageUtil) {
        List<TigNodes> tigNodesList = null;
        try {
            tigNodesList = tigNodesManager.queryTigNodesListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#queryTigNodesListWithPage has error.", e);
        }
        return tigNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.delete")
    public boolean delete(TigNodes tigNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigNodes && null != tigNodes.getNid()) {
                resultFlag = tigNodesManager.delete(tigNodes);
            } else {
                LOG.warn("TigNodesServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.batchDelete")
    public boolean delete(TigNodes[] tigNodess) {
        boolean resultFlag = false;
        try {
            if (null != tigNodess && tigNodess.length > 0) {
                resultFlag = tigNodesManager.delete(tigNodess);
            } else {
                LOG.warn("TigNodesServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigNodesService.getTigNodesById")
    public TigNodes getTigNodesById(Long id) {
        TigNodes tigNodes = null;
        try {
            if (null != id) {
                tigNodes = tigNodesManager.getTigNodesById(id);
            } else {
                LOG.warn("TigNodesServiceImpl#getTigNodesById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigNodesServiceImpl#getTigNodesById has error.", e);
        }
        return tigNodes;
    }
}

