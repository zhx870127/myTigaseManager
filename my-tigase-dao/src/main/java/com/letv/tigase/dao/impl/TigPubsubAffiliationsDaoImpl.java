package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubAffiliationsDao;
import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubAffiliationsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubAffiliationsDaoImpl extends BaseDao implements TigPubsubAffiliationsDao {
    /** namespace */
    private final String namespace = TigPubsubAffiliationsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsList(TigPubsubAffiliationsQuery queryBean) {
        return (List<TigPubsubAffiliations>) queryForList(namespace +".queryTigPubsubAffiliationsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubAffiliations tigPubsubAffiliations) {
        return insert(namespace +".insert", tigPubsubAffiliations);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubAffiliations tigPubsubAffiliations) {
        return update(namespace +".update", tigPubsubAffiliations);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubAffiliationsCount(TigPubsubAffiliationsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubAffiliationsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsListWithPage(TigPubsubAffiliationsQuery queryBean) {
        return (List<TigPubsubAffiliations>) queryForList(namespace +".queryTigPubsubAffiliationsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubAffiliations configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubAffiliations getTigPubsubAffiliationsById(Long id) {
        return (TigPubsubAffiliations) queryForObject(namespace +".getTigPubsubAffiliationsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubAffiliations tigPubsubAffiliations) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubAffiliations);
        return count > 0;
    }
}
