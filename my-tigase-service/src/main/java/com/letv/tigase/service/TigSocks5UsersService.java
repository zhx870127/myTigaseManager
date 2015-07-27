package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * TigSocks5UsersService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public interface TigSocks5UsersService {

    /**
     * 批量增加对象信息
     * 
     * @param tigSocks5UsersList
     * @return
     */
    public boolean insert(List<TigSocks5Users> tigSocks5UsersList);

    /**
     * 单个增加对象信息
     * 
     * @param tigSocks5Users
     * @return
     */
    public boolean insert(TigSocks5Users tigSocks5Users);

    /**
     * 更新 对象信息
     * 
     * @param tigSocks5Users
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigSocks5Users tigSocks5Users);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Users> queryTigSocks5UsersList(TigSocks5UsersQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigSocks5Users> queryTigSocks5UsersListWithPage(TigSocks5UsersQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigSocks5Users
     *            　
     * @return
     */
    public boolean delete(TigSocks5Users tigSocks5Users);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigSocks5Users getTigSocks5UsersById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigSocks5Userss
     *            TigSocks5Users集合
     * @return
     */
    public boolean delete(TigSocks5Users[] tigSocks5Userss);
}
