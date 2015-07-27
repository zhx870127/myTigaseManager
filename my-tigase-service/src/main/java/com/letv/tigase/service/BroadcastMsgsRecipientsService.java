package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * BroadcastMsgsRecipientsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface BroadcastMsgsRecipientsService {

    /**
     * 批量增加对象信息
     * 
     * @param broadcastMsgsRecipientsList
     * @return
     */
    public boolean insert(List<BroadcastMsgsRecipients> broadcastMsgsRecipientsList);

    /**
     * 单个增加对象信息
     * 
     * @param broadcastMsgsRecipients
     * @return
     */
    public boolean insert(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 更新 对象信息
     * 
     * @param broadcastMsgsRecipients
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsList(BroadcastMsgsRecipientsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsListWithPage(BroadcastMsgsRecipientsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param broadcastMsgsRecipients
     *            　
     * @return
     */
    public boolean delete(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public BroadcastMsgsRecipients getBroadcastMsgsRecipientsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param broadcastMsgsRecipientss
     *            BroadcastMsgsRecipients集合
     * @return
     */
    public boolean delete(BroadcastMsgsRecipients[] broadcastMsgsRecipientss);
}
