package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.domain.query.ClusterNodesQuery;
import com.letv.tigase.dao.ClusterNodesDao;
import com.letv.tigase.manager.ClusterNodesManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClusterNodesManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class ClusterNodesManagerImpl extends BaseManager implements ClusterNodesManager {
	
    @Autowired
    private ClusterNodesDao clusterNodesDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ClusterNodes> clusterNodesList) {
        boolean resultFlag = false;
        if (null != clusterNodesList && clusterNodesList.size() > 0) {
            for (ClusterNodes clusterNodes : clusterNodesList) {
                resultFlag = clusterNodesDao.insert(clusterNodes);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ClusterNodes clusterNodes) {
        return clusterNodesDao.insert(clusterNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ClusterNodes clusterNodes) {
        return clusterNodesDao.update(clusterNodes);
    }

    /**
     * {@inheritDoc}
     */
    public List<ClusterNodes> queryClusterNodesList(ClusterNodesQuery queryBean) {
        return clusterNodesDao.queryClusterNodesList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ClusterNodes> queryClusterNodesListWithPage(ClusterNodesQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ClusterNodesQuery();
        }

        // 查询总数
        int totalItem = queryClusterNodesCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return clusterNodesDao.queryClusterNodesListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryClusterNodesCount(ClusterNodesQuery queryBean) {
        return clusterNodesDao.queryClusterNodesCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ClusterNodes clusterNodes) {
        return clusterNodesDao.delete(clusterNodes);
    }

    /**
     * {@inheritDoc}
     */
    public ClusterNodes getClusterNodesById(String id) {
        return clusterNodesDao.getClusterNodesById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ClusterNodes[] clusterNodess) {
        boolean resultFlag = false;
        if (null != clusterNodess && clusterNodess.length > 0) {
            for (int i = 0; i < clusterNodess.length; i++) {
                resultFlag = delete(clusterNodess[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(ClusterNodes clusterNodes) {
        return clusterNodesDao.exist(clusterNodes);
    }
}
