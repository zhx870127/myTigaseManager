package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigPubsubSubscriptionsManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigPubsubSubscriptionsManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigPubsubSubscriptionsList
     * @return
     */
    public boolean insert(List<TigPubsubSubscriptions> tigPubsubSubscriptionsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    public boolean insert(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 更新 对象信息
     * 
     * @param tigPubsubSubscriptions
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsList(TigPubsubSubscriptionsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsListWithPage(TigPubsubSubscriptionsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigPubsubSubscriptionsCount(TigPubsubSubscriptionsQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubSubscriptions
     *            　
     * @return
     */
    public boolean delete(TigPubsubSubscriptions tigPubsubSubscriptions);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigPubsubSubscriptions getTigPubsubSubscriptionsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubSubscriptionss
     *            TigPubsubSubscriptions集合
     * @return
     */
    public boolean delete(TigPubsubSubscriptions[] tigPubsubSubscriptionss);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    public boolean exist(TigPubsubSubscriptions tigPubsubSubscriptions);
}
