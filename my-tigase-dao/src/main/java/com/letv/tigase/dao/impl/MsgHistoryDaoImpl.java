package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.MsgHistoryDao;
import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * MsgHistoryDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class MsgHistoryDaoImpl extends BaseDao implements MsgHistoryDao {
    /** namespace */
    private final String namespace = MsgHistoryDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<MsgHistory> queryMsgHistoryList(MsgHistoryQuery queryBean) {
        return (List<MsgHistory>) queryForList(namespace +".queryMsgHistoryList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(MsgHistory msgHistory) {
        return insert(namespace +".insert", msgHistory);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(MsgHistory msgHistory) {
        return update(namespace +".update", msgHistory);
    }

    /**
     * {@inheritDoc}
     */
    public int queryMsgHistoryCount(MsgHistoryQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryMsgHistoryCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<MsgHistory> queryMsgHistoryListWithPage(MsgHistoryQuery queryBean) {
        return (List<MsgHistory>) queryForList(namespace +".queryMsgHistoryListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(MsgHistory configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public MsgHistory getMsgHistoryById(Long id) {
        return (MsgHistory) queryForObject(namespace +".getMsgHistoryById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(MsgHistory msgHistory) {
        int count = (Integer) queryForObject(namespace +".exist", msgHistory);
        return count > 0;
    }
}
