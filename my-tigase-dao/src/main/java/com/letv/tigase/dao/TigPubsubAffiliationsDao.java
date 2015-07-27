package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;
/**
 * TigPubsubAffiliationsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubAffiliationsDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubAffiliations 
     * @return
     */
    public boolean insert(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 更新对象
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    public boolean update(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsList(TigPubsubAffiliationsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubAffiliationsCount(TigPubsubAffiliationsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsListWithPage(TigPubsubAffiliationsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    public boolean delete(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubAffiliations getTigPubsubAffiliationsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    public boolean exist(TigPubsubAffiliations tigPubsubAffiliations);

}
