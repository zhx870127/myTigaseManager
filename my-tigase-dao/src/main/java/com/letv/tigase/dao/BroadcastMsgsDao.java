package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
/**
 * BroadcastMsgsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface BroadcastMsgsDao {
    
    /**
     * 新增对象
     * 
     * @param broadcastMsgs 
     * @return
     */
    public boolean insert(BroadcastMsgs broadcastMsgs);

    /**
     * 更新对象
     * 
     * @param broadcastMsgs
     * @return
     */
    public boolean update(BroadcastMsgs broadcastMsgs);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgs> queryBroadcastMsgsList(BroadcastMsgsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryBroadcastMsgsCount(BroadcastMsgsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgs> queryBroadcastMsgsListWithPage(BroadcastMsgsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param broadcastMsgs
     * @return
     */
    public boolean delete(BroadcastMsgs broadcastMsgs);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public BroadcastMsgs getBroadcastMsgsById(String id);

    /**
     * 判断是否存在
     * 
     * @param broadcastMsgs
     * @return
     */
    public boolean exist(BroadcastMsgs broadcastMsgs);

}
