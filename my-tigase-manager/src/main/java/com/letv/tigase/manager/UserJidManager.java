package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.UserJid;
import com.letv.tigase.domain.query.UserJidQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * UserJidManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface UserJidManager {

    /**
     * 批量增加对象信息
     * 
     * @param userJidList
     * @return
     */
    public boolean insert(List<UserJid> userJidList);

    /**
     * 单个增加对象信息
     * 
     * @param userJid
     * @return
     */
    public boolean insert(UserJid userJid);

    /**
     * 更新 对象信息
     * 
     * @param userJid
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserJid userJid);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserJid> queryUserJidList(UserJidQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserJid> queryUserJidListWithPage(UserJidQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryUserJidCount(UserJidQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userJid
     *            　
     * @return
     */
    public boolean delete(UserJid userJid);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserJid getUserJidById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userJids
     *            UserJid集合
     * @return
     */
    public boolean delete(UserJid[] userJids);

    /**
     * 判断是否存在
     * 
     * @param userJid
     * @return
     */
    public boolean exist(UserJid userJid);
}
