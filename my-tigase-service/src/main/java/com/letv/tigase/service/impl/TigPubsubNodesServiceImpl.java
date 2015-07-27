package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
import com.letv.tigase.manager.TigPubsubNodesManager;
import com.letv.tigase.service.TigPubsubNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubNodesService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubNodesServiceImpl implements TigPubsubNodesService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubNodesServiceImpl.class);

    @Autowired
    private TigPubsubNodesManager tigPubsubNodesManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.batchInsert")
    public boolean insert(List<TigPubsubNodes> tigPubsubNodesList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubNodesList)) {
                resultFlag = tigPubsubNodesManager.insert(tigPubsubNodesList);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.insert")
    public boolean insert(TigPubsubNodes tigPubsubNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubNodes) {
                if (tigPubsubNodesManager.exist(tigPubsubNodes)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubNodesManager.insert(tigPubsubNodes);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubNodesServiceImpl#insert failed, tigPubsubNodes has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.update")
    public boolean update(TigPubsubNodes tigPubsubNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubNodes && null != tigPubsubNodes.getNodeId()) {
                resultFlag = tigPubsubNodesManager.update(tigPubsubNodes);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.queryTigPubsubNodesList")
    public List<TigPubsubNodes> queryTigPubsubNodesList(TigPubsubNodesQuery queryBean) {
        List<TigPubsubNodes> tigPubsubNodesList = null;
        try {
            tigPubsubNodesList = tigPubsubNodesManager.queryTigPubsubNodesList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#queryTigPubsubNodesList has error.", e);
        }
        return tigPubsubNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.queryTigPubsubNodesListWithPage")
    public List<TigPubsubNodes> queryTigPubsubNodesListWithPage(TigPubsubNodesQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubNodes> tigPubsubNodesList = null;
        try {
            tigPubsubNodesList = tigPubsubNodesManager.queryTigPubsubNodesListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#queryTigPubsubNodesListWithPage has error.", e);
        }
        return tigPubsubNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.delete")
    public boolean delete(TigPubsubNodes tigPubsubNodes) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubNodes && null != tigPubsubNodes.getNodeId()) {
                resultFlag = tigPubsubNodesManager.delete(tigPubsubNodes);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.batchDelete")
    public boolean delete(TigPubsubNodes[] tigPubsubNodess) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubNodess && tigPubsubNodess.length > 0) {
                resultFlag = tigPubsubNodesManager.delete(tigPubsubNodess);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubNodesService.getTigPubsubNodesById")
    public TigPubsubNodes getTigPubsubNodesById(Long id) {
        TigPubsubNodes tigPubsubNodes = null;
        try {
            if (null != id) {
                tigPubsubNodes = tigPubsubNodesManager.getTigPubsubNodesById(id);
            } else {
                LOG.warn("TigPubsubNodesServiceImpl#getTigPubsubNodesById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubNodesServiceImpl#getTigPubsubNodesById has error.", e);
        }
        return tigPubsubNodes;
    }
}

