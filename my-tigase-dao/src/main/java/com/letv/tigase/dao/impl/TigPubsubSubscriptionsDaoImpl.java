package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubSubscriptionsDao;
import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubSubscriptionsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubSubscriptionsDaoImpl extends BaseDao implements TigPubsubSubscriptionsDao {
    /** namespace */
    private final String namespace = TigPubsubSubscriptionsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsList(TigPubsubSubscriptionsQuery queryBean) {
        return (List<TigPubsubSubscriptions>) queryForList(namespace +".queryTigPubsubSubscriptionsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubSubscriptions tigPubsubSubscriptions) {
        return insert(namespace +".insert", tigPubsubSubscriptions);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubSubscriptions tigPubsubSubscriptions) {
        return update(namespace +".update", tigPubsubSubscriptions);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubSubscriptionsCount(TigPubsubSubscriptionsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubSubscriptionsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsListWithPage(TigPubsubSubscriptionsQuery queryBean) {
        return (List<TigPubsubSubscriptions>) queryForList(namespace +".queryTigPubsubSubscriptionsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubSubscriptions configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubSubscriptions getTigPubsubSubscriptionsById(Long id) {
        return (TigPubsubSubscriptions) queryForObject(namespace +".getTigPubsubSubscriptionsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubSubscriptions tigPubsubSubscriptions) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubSubscriptions);
        return count > 0;
    }
}
