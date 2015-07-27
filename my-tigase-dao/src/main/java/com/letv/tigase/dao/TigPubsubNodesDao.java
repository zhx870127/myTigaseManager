package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
/**
 * TigPubsubNodesDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubNodesDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubNodes 
     * @return
     */
    public boolean insert(TigPubsubNodes tigPubsubNodes);

    /**
     * 更新对象
     * 
     * @param tigPubsubNodes
     * @return
     */
    public boolean update(TigPubsubNodes tigPubsubNodes);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubNodes> queryTigPubsubNodesList(TigPubsubNodesQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubNodesCount(TigPubsubNodesQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubNodes> queryTigPubsubNodesListWithPage(TigPubsubNodesQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubNodes
     * @return
     */
    public boolean delete(TigPubsubNodes tigPubsubNodes);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubNodes getTigPubsubNodesById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubNodes
     * @return
     */
    public boolean exist(TigPubsubNodes tigPubsubNodes);

}
