package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
/**
 * BroadcastMsgsRecipientsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface BroadcastMsgsRecipientsDao {
    
    /**
     * 新增对象
     * 
     * @param broadcastMsgsRecipients 
     * @return
     */
    public boolean insert(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 更新对象
     * 
     * @param broadcastMsgsRecipients
     * @return
     */
    public boolean update(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsList(BroadcastMsgsRecipientsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryBroadcastMsgsRecipientsCount(BroadcastMsgsRecipientsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsListWithPage(BroadcastMsgsRecipientsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param broadcastMsgsRecipients
     * @return
     */
    public boolean delete(BroadcastMsgsRecipients broadcastMsgsRecipients);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public BroadcastMsgsRecipients getBroadcastMsgsRecipientsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param broadcastMsgsRecipients
     * @return
     */
    public boolean exist(BroadcastMsgsRecipients broadcastMsgsRecipients);

}
