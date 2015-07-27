package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubJidsDao;
import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubJidsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubJidsDaoImpl extends BaseDao implements TigPubsubJidsDao {
    /** namespace */
    private final String namespace = TigPubsubJidsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubJids> queryTigPubsubJidsList(TigPubsubJidsQuery queryBean) {
        return (List<TigPubsubJids>) queryForList(namespace +".queryTigPubsubJidsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubJids tigPubsubJids) {
        return insert(namespace +".insert", tigPubsubJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubJids tigPubsubJids) {
        return update(namespace +".update", tigPubsubJids);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubJidsCount(TigPubsubJidsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubJidsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubJids> queryTigPubsubJidsListWithPage(TigPubsubJidsQuery queryBean) {
        return (List<TigPubsubJids>) queryForList(namespace +".queryTigPubsubJidsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubJids configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubJids getTigPubsubJidsById(Long id) {
        return (TigPubsubJids) queryForObject(namespace +".getTigPubsubJidsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubJids tigPubsubJids) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubJids);
        return count > 0;
    }
}
