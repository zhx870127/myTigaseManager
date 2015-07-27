package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigMaJidsDao;
import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigMaJidsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigMaJidsDaoImpl extends BaseDao implements TigMaJidsDao {
    /** namespace */
    private final String namespace = TigMaJidsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigMaJids> queryTigMaJidsList(TigMaJidsQuery queryBean) {
        return (List<TigMaJids>) queryForList(namespace +".queryTigMaJidsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigMaJids tigMaJids) {
        return insert(namespace +".insert", tigMaJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigMaJids tigMaJids) {
        return update(namespace +".update", tigMaJids);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaJidsCount(TigMaJidsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigMaJidsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaJids> queryTigMaJidsListWithPage(TigMaJidsQuery queryBean) {
        return (List<TigMaJids>) queryForList(namespace +".queryTigMaJidsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaJids configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaJids getTigMaJidsById(Long id) {
        return (TigMaJids) queryForObject(namespace +".getTigMaJidsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigMaJids tigMaJids) {
        int count = (Integer) queryForObject(namespace +".exist", tigMaJids);
        return count > 0;
    }
}
