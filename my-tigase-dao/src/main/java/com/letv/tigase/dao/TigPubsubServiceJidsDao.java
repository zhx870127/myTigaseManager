package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
/**
 * TigPubsubServiceJidsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubServiceJidsDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubServiceJids 
     * @return
     */
    public boolean insert(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 更新对象
     * 
     * @param tigPubsubServiceJids
     * @return
     */
    public boolean update(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsList(TigPubsubServiceJidsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubServiceJidsCount(TigPubsubServiceJidsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsListWithPage(TigPubsubServiceJidsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubServiceJids
     * @return
     */
    public boolean delete(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubServiceJids getTigPubsubServiceJidsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubServiceJids
     * @return
     */
    public boolean exist(TigPubsubServiceJids tigPubsubServiceJids);

}
