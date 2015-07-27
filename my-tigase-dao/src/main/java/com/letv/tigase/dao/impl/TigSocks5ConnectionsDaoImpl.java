package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigSocks5ConnectionsDao;
import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigSocks5ConnectionsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigSocks5ConnectionsDaoImpl extends BaseDao implements TigSocks5ConnectionsDao {
    /** namespace */
    private final String namespace = TigSocks5ConnectionsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsList(TigSocks5ConnectionsQuery queryBean) {
        return (List<TigSocks5Connections>) queryForList(namespace +".queryTigSocks5ConnectionsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigSocks5Connections tigSocks5Connections) {
        return insert(namespace +".insert", tigSocks5Connections);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigSocks5Connections tigSocks5Connections) {
        return update(namespace +".update", tigSocks5Connections);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigSocks5ConnectionsCount(TigSocks5ConnectionsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigSocks5ConnectionsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsListWithPage(TigSocks5ConnectionsQuery queryBean) {
        return (List<TigSocks5Connections>) queryForList(namespace +".queryTigSocks5ConnectionsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigSocks5Connections configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigSocks5Connections getTigSocks5ConnectionsById(Long id) {
        return (TigSocks5Connections) queryForObject(namespace +".getTigSocks5ConnectionsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigSocks5Connections tigSocks5Connections) {
        int count = (Integer) queryForObject(namespace +".exist", tigSocks5Connections);
        return count > 0;
    }
}
