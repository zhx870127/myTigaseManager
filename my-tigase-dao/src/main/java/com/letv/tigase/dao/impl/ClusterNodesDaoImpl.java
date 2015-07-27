package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.ClusterNodesDao;
import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.domain.query.ClusterNodesQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ClusterNodesDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class ClusterNodesDaoImpl extends BaseDao implements ClusterNodesDao {
    /** namespace */
    private final String namespace = ClusterNodesDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ClusterNodes> queryClusterNodesList(ClusterNodesQuery queryBean) {
        return (List<ClusterNodes>) queryForList(namespace +".queryClusterNodesList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ClusterNodes clusterNodes) {
        return insert(namespace +".insert", clusterNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ClusterNodes clusterNodes) {
        return update(namespace +".update", clusterNodes);
    }

    /**
     * {@inheritDoc}
     */
    public int queryClusterNodesCount(ClusterNodesQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryClusterNodesCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ClusterNodes> queryClusterNodesListWithPage(ClusterNodesQuery queryBean) {
        return (List<ClusterNodes>) queryForList(namespace +".queryClusterNodesListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ClusterNodes configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ClusterNodes getClusterNodesById(String id) {
        return (ClusterNodes) queryForObject(namespace +".getClusterNodesById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ClusterNodes clusterNodes) {
        int count = (Integer) queryForObject(namespace +".exist", clusterNodes);
        return count > 0;
    }
}
