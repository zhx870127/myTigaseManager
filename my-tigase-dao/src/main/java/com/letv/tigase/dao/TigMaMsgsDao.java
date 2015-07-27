package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
/**
 * TigMaMsgsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigMaMsgsDao {
    
    /**
     * 新增对象
     * 
     * @param tigMaMsgs 
     * @return
     */
    public boolean insert(TigMaMsgs tigMaMsgs);

    /**
     * 更新对象
     * 
     * @param tigMaMsgs
     * @return
     */
    public boolean update(TigMaMsgs tigMaMsgs);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaMsgs> queryTigMaMsgsList(TigMaMsgsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigMaMsgsCount(TigMaMsgsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaMsgs> queryTigMaMsgsListWithPage(TigMaMsgsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigMaMsgs
     * @return
     */
    public boolean delete(TigMaMsgs tigMaMsgs);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigMaMsgs getTigMaMsgsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigMaMsgs
     * @return
     */
    public boolean exist(TigMaMsgs tigMaMsgs);

}
