package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.BroadcastMsgsRecipientsDao;
import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * BroadcastMsgsRecipientsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class BroadcastMsgsRecipientsDaoImpl extends BaseDao implements BroadcastMsgsRecipientsDao {
    /** namespace */
    private final String namespace = BroadcastMsgsRecipientsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsList(BroadcastMsgsRecipientsQuery queryBean) {
        return (List<BroadcastMsgsRecipients>) queryForList(namespace +".queryBroadcastMsgsRecipientsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return insert(namespace +".insert", broadcastMsgsRecipients);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return update(namespace +".update", broadcastMsgsRecipients);
    }

    /**
     * {@inheritDoc}
     */
    public int queryBroadcastMsgsRecipientsCount(BroadcastMsgsRecipientsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryBroadcastMsgsRecipientsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsListWithPage(BroadcastMsgsRecipientsQuery queryBean) {
        return (List<BroadcastMsgsRecipients>) queryForList(namespace +".queryBroadcastMsgsRecipientsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BroadcastMsgsRecipients configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public BroadcastMsgsRecipients getBroadcastMsgsRecipientsById(Long id) {
        return (BroadcastMsgsRecipients) queryForObject(namespace +".getBroadcastMsgsRecipientsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        int count = (Integer) queryForObject(namespace +".exist", broadcastMsgsRecipients);
        return count > 0;
    }
}
