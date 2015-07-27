package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.BroadcastMsgsDao;
import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * BroadcastMsgsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class BroadcastMsgsDaoImpl extends BaseDao implements BroadcastMsgsDao {
    /** namespace */
    private final String namespace = BroadcastMsgsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgs> queryBroadcastMsgsList(BroadcastMsgsQuery queryBean) {
        return (List<BroadcastMsgs>) queryForList(namespace +".queryBroadcastMsgsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(BroadcastMsgs broadcastMsgs) {
        return insert(namespace +".insert", broadcastMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(BroadcastMsgs broadcastMsgs) {
        return update(namespace +".update", broadcastMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public int queryBroadcastMsgsCount(BroadcastMsgsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryBroadcastMsgsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgs> queryBroadcastMsgsListWithPage(BroadcastMsgsQuery queryBean) {
        return (List<BroadcastMsgs>) queryForList(namespace +".queryBroadcastMsgsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BroadcastMsgs configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public BroadcastMsgs getBroadcastMsgsById(String id) {
        return (BroadcastMsgs) queryForObject(namespace +".getBroadcastMsgsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(BroadcastMsgs broadcastMsgs) {
        int count = (Integer) queryForObject(namespace +".exist", broadcastMsgs);
        return count > 0;
    }
}
