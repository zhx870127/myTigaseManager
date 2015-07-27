package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;
/**
 * TigPubsubItemsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubItemsDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubItems 
     * @return
     */
    public boolean insert(TigPubsubItems tigPubsubItems);

    /**
     * 更新对象
     * 
     * @param tigPubsubItems
     * @return
     */
    public boolean update(TigPubsubItems tigPubsubItems);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubItems> queryTigPubsubItemsList(TigPubsubItemsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubItemsCount(TigPubsubItemsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubItems> queryTigPubsubItemsListWithPage(TigPubsubItemsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubItems
     * @return
     */
    public boolean delete(TigPubsubItems tigPubsubItems);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubItems getTigPubsubItemsById(String id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubItems
     * @return
     */
    public boolean exist(TigPubsubItems tigPubsubItems);

}
