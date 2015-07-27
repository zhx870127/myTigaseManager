package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * MsgHistoryService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface MsgHistoryService {

    /**
     * 批量增加对象信息
     * 
     * @param msgHistoryList
     * @return
     */
    public boolean insert(List<MsgHistory> msgHistoryList);

    /**
     * 单个增加对象信息
     * 
     * @param msgHistory
     * @return
     */
    public boolean insert(MsgHistory msgHistory);

    /**
     * 更新 对象信息
     * 
     * @param msgHistory
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(MsgHistory msgHistory);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<MsgHistory> queryMsgHistoryList(MsgHistoryQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<MsgHistory> queryMsgHistoryListWithPage(MsgHistoryQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param msgHistory
     *            　
     * @return
     */
    public boolean delete(MsgHistory msgHistory);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public MsgHistory getMsgHistoryById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param msgHistorys
     *            MsgHistory集合
     * @return
     */
    public boolean delete(MsgHistory[] msgHistorys);
}
