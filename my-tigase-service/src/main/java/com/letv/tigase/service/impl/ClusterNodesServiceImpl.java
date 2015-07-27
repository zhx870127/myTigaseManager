package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.domain.query.ClusterNodesQuery;
import com.letv.tigase.manager.ClusterNodesManager;
import com.letv.tigase.service.ClusterNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ClusterNodesService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class ClusterNodesServiceImpl implements ClusterNodesService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ClusterNodesServiceImpl.class);

    @Autowired
    private ClusterNodesManager clusterNodesManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.batchInsert")
    public boolean insert(List<ClusterNodes> clusterNodesList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(clusterNodesList)) {
                resultFlag = clusterNodesManager.insert(clusterNodesList);
            } else {
                LOG.warn("ClusterNodesServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.insert")
    public boolean insert(ClusterNodes clusterNodes) {
        boolean resultFlag = false;
        try {
            if (null != clusterNodes) {
                if (clusterNodesManager.exist(clusterNodes)) {
                    throw new ExistedException();
                }
                resultFlag = clusterNodesManager.insert(clusterNodes);
            } else {
                LOG.warn("ClusterNodesServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ClusterNodesServiceImpl#insert failed, clusterNodes has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.update")
    public boolean update(ClusterNodes clusterNodes) {
        boolean resultFlag = false;
        try {
            if (null != clusterNodes && null != clusterNodes.getHostname()) {
                resultFlag = clusterNodesManager.update(clusterNodes);
            } else {
                LOG.warn("ClusterNodesServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.queryClusterNodesList")
    public List<ClusterNodes> queryClusterNodesList(ClusterNodesQuery queryBean) {
        List<ClusterNodes> clusterNodesList = null;
        try {
            clusterNodesList = clusterNodesManager.queryClusterNodesList(queryBean);
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#queryClusterNodesList has error.", e);
        }
        return clusterNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.queryClusterNodesListWithPage")
    public List<ClusterNodes> queryClusterNodesListWithPage(ClusterNodesQuery queryBean, PageUtil pageUtil) {
        List<ClusterNodes> clusterNodesList = null;
        try {
            clusterNodesList = clusterNodesManager.queryClusterNodesListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#queryClusterNodesListWithPage has error.", e);
        }
        return clusterNodesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.delete")
    public boolean delete(ClusterNodes clusterNodes) {
        boolean resultFlag = false;
        try {
            if (null != clusterNodes && null != clusterNodes.getHostname()) {
                resultFlag = clusterNodesManager.delete(clusterNodes);
            } else {
                LOG.warn("ClusterNodesServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.batchDelete")
    public boolean delete(ClusterNodes[] clusterNodess) {
        boolean resultFlag = false;
        try {
            if (null != clusterNodess && clusterNodess.length > 0) {
                resultFlag = clusterNodesManager.delete(clusterNodess);
            } else {
                LOG.warn("ClusterNodesServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ClusterNodesService.getClusterNodesById")
    public ClusterNodes getClusterNodesById(String id) {
        ClusterNodes clusterNodes = null;
        try {
            if (null != id) {
                clusterNodes = clusterNodesManager.getClusterNodesById(id);
            } else {
                LOG.warn("ClusterNodesServiceImpl#getClusterNodesById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ClusterNodesServiceImpl#getClusterNodesById has error.", e);
        }
        return clusterNodes;
    }
}

