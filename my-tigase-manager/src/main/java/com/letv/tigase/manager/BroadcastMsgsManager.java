package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * BroadcastMsgsManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface BroadcastMsgsManager {

    /**
     * 批量增加对象信息
     * 
     * @param broadcastMsgsList
     * @return
     */
    public boolean insert(List<BroadcastMsgs> broadcastMsgsList);

    /**
     * 单个增加对象信息
     * 
     * @param broadcastMsgs
     * @return
     */
    public boolean insert(BroadcastMsgs broadcastMsgs);

    /**
     * 更新 对象信息
     * 
     * @param broadcastMsgs
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(BroadcastMsgs broadcastMsgs);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgs> queryBroadcastMsgsList(BroadcastMsgsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<BroadcastMsgs> queryBroadcastMsgsListWithPage(BroadcastMsgsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryBroadcastMsgsCount(BroadcastMsgsQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param broadcastMsgs
     *            　
     * @return
     */
    public boolean delete(BroadcastMsgs broadcastMsgs);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public BroadcastMsgs getBroadcastMsgsById(String id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param broadcastMsgss
     *            BroadcastMsgs集合
     * @return
     */
    public boolean delete(BroadcastMsgs[] broadcastMsgss);

    /**
     * 判断是否存在
     * 
     * @param broadcastMsgs
     * @return
     */
    public boolean exist(BroadcastMsgs broadcastMsgs);
}
