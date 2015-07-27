package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;
/**
 * TigPubsubJidsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigPubsubJidsDao {
    
    /**
     * 新增对象
     * 
     * @param tigPubsubJids 
     * @return
     */
    public boolean insert(TigPubsubJids tigPubsubJids);

    /**
     * 更新对象
     * 
     * @param tigPubsubJids
     * @return
     */
    public boolean update(TigPubsubJids tigPubsubJids);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubJids> queryTigPubsubJidsList(TigPubsubJidsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigPubsubJidsCount(TigPubsubJidsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubJids> queryTigPubsubJidsListWithPage(TigPubsubJidsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigPubsubJids
     * @return
     */
    public boolean delete(TigPubsubJids tigPubsubJids);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigPubsubJids getTigPubsubJidsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubJids
     * @return
     */
    public boolean exist(TigPubsubJids tigPubsubJids);

}
