package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
/**
 * TigPubsubSubscriptionsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubSubscriptionsDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubSubscriptions 
     * @return
     */
    public boolean insert(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 更新对象
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    public boolean update(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsList(TigPubsubSubscriptionsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubSubscriptionsCount(TigPubsubSubscriptionsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsListWithPage(TigPubsubSubscriptionsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    public boolean delete(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubSubscriptions getTigPubsubSubscriptionsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    public boolean exist(TigPubsubSubscriptions tigPubsubSubscriptions);

}
