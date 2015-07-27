package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
/**
 * TigSocks5ConnectionsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigSocks5ConnectionsDao {
    
    /**
     * 新增对象
     * 
     * @param tigSocks5Connections 
     * @return
     */
    public boolean insert(TigSocks5Connections tigSocks5Connections);

    /**
     * 更新对象
     * 
     * @param tigSocks5Connections
     * @return
     */
    public boolean update(TigSocks5Connections tigSocks5Connections);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsList(TigSocks5ConnectionsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigSocks5ConnectionsCount(TigSocks5ConnectionsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsListWithPage(TigSocks5ConnectionsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigSocks5Connections
     * @return
     */
    public boolean delete(TigSocks5Connections tigSocks5Connections);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigSocks5Connections getTigSocks5ConnectionsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigSocks5Connections
     * @return
     */
    public boolean exist(TigSocks5Connections tigSocks5Connections);

}
