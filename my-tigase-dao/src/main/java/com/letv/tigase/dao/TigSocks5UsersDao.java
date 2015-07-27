package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;
/**
 * TigSocks5UsersDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigSocks5UsersDao {
    
    /**
     * 新增对象
     * 
     * @param tigSocks5Users 
     * @return
     */
    public boolean insert(TigSocks5Users tigSocks5Users);

    /**
     * 更新对象
     * 
     * @param tigSocks5Users
     * @return
     */
    public boolean update(TigSocks5Users tigSocks5Users);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Users> queryTigSocks5UsersList(TigSocks5UsersQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigSocks5UsersCount(TigSocks5UsersQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Users> queryTigSocks5UsersListWithPage(TigSocks5UsersQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigSocks5Users
     * @return
     */
    public boolean delete(TigSocks5Users tigSocks5Users);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigSocks5Users getTigSocks5UsersById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigSocks5Users
     * @return
     */
    public boolean exist(TigSocks5Users tigSocks5Users);

}
