package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
/**
 * MsgHistoryDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface MsgHistoryDao {
    
    /**
     * 新增对象
     * 
     * @param msgHistory 
     * @return
     */
    public boolean insert(MsgHistory msgHistory);

    /**
     * 更新对象
     * 
     * @param msgHistory
     * @return
     */
    public boolean update(MsgHistory msgHistory);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<MsgHistory> queryMsgHistoryList(MsgHistoryQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryMsgHistoryCount(MsgHistoryQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<MsgHistory> queryMsgHistoryListWithPage(MsgHistoryQuery queryBean);

    /**
     * 删除记录
     * 
     * @param msgHistory
     * @return
     */
    public boolean delete(MsgHistory msgHistory);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public MsgHistory getMsgHistoryById(Long id);

    /**
     * 判断是否存在
     * 
     * @param msgHistory
     * @return
     */
    public boolean exist(MsgHistory msgHistory);

}
