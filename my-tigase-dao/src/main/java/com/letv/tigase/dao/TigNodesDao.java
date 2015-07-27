package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;
/**
 * TigNodesDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigNodesDao {
    
    /**
     * 新增对象
     * 
     * @param tigNodes 
     * @return
     */
    public boolean insert(TigNodes tigNodes);

    /**
     * 更新对象
     * 
     * @param tigNodes
     * @return
     */
    public boolean update(TigNodes tigNodes);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigNodes> queryTigNodesList(TigNodesQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigNodesCount(TigNodesQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigNodes> queryTigNodesListWithPage(TigNodesQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigNodes
     * @return
     */
    public boolean delete(TigNodes tigNodes);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigNodes getTigNodesById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigNodes
     * @return
     */
    public boolean exist(TigNodes tigNodes);

}
