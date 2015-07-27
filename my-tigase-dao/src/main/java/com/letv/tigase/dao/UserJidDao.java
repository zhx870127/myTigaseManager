package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.UserJid;
import com.letv.tigase.domain.query.UserJidQuery;
/**
 * UserJidDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface UserJidDao {
    
    /**
     * 新增对象
     * 
     * @param userJid 
     * @return
     */
    public boolean insert(UserJid userJid);

    /**
     * 更新对象
     * 
     * @param userJid
     * @return
     */
    public boolean update(UserJid userJid);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserJid> queryUserJidList(UserJidQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserJidCount(UserJidQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserJid> queryUserJidListWithPage(UserJidQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userJid
     * @return
     */
    public boolean delete(UserJid userJid);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserJid getUserJidById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userJid
     * @return
     */
    public boolean exist(UserJid userJid);

}
