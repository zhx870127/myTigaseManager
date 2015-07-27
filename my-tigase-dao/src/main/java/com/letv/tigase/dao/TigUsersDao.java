package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.domain.query.TigUsersQuery;
/**
 * TigUsersDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigUsersDao {
    
    /**
     * 新增对象
     * 
     * @param tigUsers 
     * @return
     */
    public boolean insert(TigUsers tigUsers);

    /**
     * 更新对象
     * 
     * @param tigUsers
     * @return
     */
    public boolean update(TigUsers tigUsers);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigUsers> queryTigUsersList(TigUsersQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigUsersCount(TigUsersQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigUsers> queryTigUsersListWithPage(TigUsersQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigUsers
     * @return
     */
    public boolean delete(TigUsers tigUsers);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigUsers getTigUsersById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigUsers
     * @return
     */
    public boolean exist(TigUsers tigUsers);

}
