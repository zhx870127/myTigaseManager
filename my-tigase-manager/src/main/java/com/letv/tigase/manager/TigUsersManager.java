package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.domain.query.TigUsersQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigUsersManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigUsersManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigUsersList
     * @return
     */
    public boolean insert(List<TigUsers> tigUsersList);

    /**
     * 单个增加对象信息
     * 
     * @param tigUsers
     * @return
     */
    public boolean insert(TigUsers tigUsers);

    /**
     * 更新 对象信息
     * 
     * @param tigUsers
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigUsers tigUsers);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigUsers> queryTigUsersList(TigUsersQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigUsers> queryTigUsersListWithPage(TigUsersQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigUsersCount(TigUsersQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigUsers
     *            　
     * @return
     */
    public boolean delete(TigUsers tigUsers);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigUsers getTigUsersById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigUserss
     *            TigUsers集合
     * @return
     */
    public boolean delete(TigUsers[] tigUserss);

    /**
     * 判断是否存在
     * 
     * @param tigUsers
     * @return
     */
    public boolean exist(TigUsers tigUsers);
}
