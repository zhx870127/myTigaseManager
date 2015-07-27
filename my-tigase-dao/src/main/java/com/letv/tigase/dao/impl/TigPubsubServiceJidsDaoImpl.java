package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubServiceJidsDao;
import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubServiceJidsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubServiceJidsDaoImpl extends BaseDao implements TigPubsubServiceJidsDao {
    /** namespace */
    private final String namespace = TigPubsubServiceJidsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsList(TigPubsubServiceJidsQuery queryBean) {
        return (List<TigPubsubServiceJids>) queryForList(namespace +".queryTigPubsubServiceJidsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubServiceJids tigPubsubServiceJids) {
        return insert(namespace +".insert", tigPubsubServiceJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubServiceJids tigPubsubServiceJids) {
        return update(namespace +".update", tigPubsubServiceJids);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubServiceJidsCount(TigPubsubServiceJidsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubServiceJidsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsListWithPage(TigPubsubServiceJidsQuery queryBean) {
        return (List<TigPubsubServiceJids>) queryForList(namespace +".queryTigPubsubServiceJidsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubServiceJids configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubServiceJids getTigPubsubServiceJidsById(Long id) {
        return (TigPubsubServiceJids) queryForObject(namespace +".getTigPubsubServiceJidsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubServiceJids tigPubsubServiceJids) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubServiceJids);
        return count > 0;
    }
}
