package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubItemsDao;
import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubItemsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubItemsDaoImpl extends BaseDao implements TigPubsubItemsDao {
    /** namespace */
    private final String namespace = TigPubsubItemsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubItems> queryTigPubsubItemsList(TigPubsubItemsQuery queryBean) {
        return (List<TigPubsubItems>) queryForList(namespace +".queryTigPubsubItemsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubItems tigPubsubItems) {
        return insert(namespace +".insert", tigPubsubItems);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubItems tigPubsubItems) {
        return update(namespace +".update", tigPubsubItems);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubItemsCount(TigPubsubItemsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubItemsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubItems> queryTigPubsubItemsListWithPage(TigPubsubItemsQuery queryBean) {
        return (List<TigPubsubItems>) queryForList(namespace +".queryTigPubsubItemsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubItems configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubItems getTigPubsubItemsById(String id) {
        return (TigPubsubItems) queryForObject(namespace +".getTigPubsubItemsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubItems tigPubsubItems) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubItems);
        return count > 0;
    }
}
