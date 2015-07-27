package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.domain.query.ClusterNodesQuery;
/**
 * ClusterNodesDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface ClusterNodesDao {
    
    /**
     * 新增对象
     * 
     * @param clusterNodes 
     * @return
     */
    public boolean insert(ClusterNodes clusterNodes);

    /**
     * 更新对象
     * 
     * @param clusterNodes
     * @return
     */
    public boolean update(ClusterNodes clusterNodes);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ClusterNodes> queryClusterNodesList(ClusterNodesQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryClusterNodesCount(ClusterNodesQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ClusterNodes> queryClusterNodesListWithPage(ClusterNodesQuery queryBean);

    /**
     * 删除记录
     * 
     * @param clusterNodes
     * @return
     */
    public boolean delete(ClusterNodes clusterNodes);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ClusterNodes getClusterNodesById(String id);

    /**
     * 判断是否存在
     * 
     * @param clusterNodes
     * @return
     */
    public boolean exist(ClusterNodes clusterNodes);

}
