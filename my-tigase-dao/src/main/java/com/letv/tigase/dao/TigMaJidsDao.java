package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;
/**
 * TigMaJidsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigMaJidsDao {
    
    /**
     * 新增对象
     * 
     * @param tigMaJids 
     * @return
     */
    public boolean insert(TigMaJids tigMaJids);

    /**
     * 更新对象
     * 
     * @param tigMaJids
     * @return
     */
    public boolean update(TigMaJids tigMaJids);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaJids> queryTigMaJidsList(TigMaJidsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigMaJidsCount(TigMaJidsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaJids> queryTigMaJidsListWithPage(TigMaJidsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigMaJids
     * @return
     */
    public boolean delete(TigMaJids tigMaJids);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigMaJids getTigMaJidsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigMaJids
     * @return
     */
    public boolean exist(TigMaJids tigMaJids);

}
