package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigPubsubNodesDao;
import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigPubsubNodesDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigPubsubNodesDaoImpl extends BaseDao implements TigPubsubNodesDao {
    /** namespace */
    private final String namespace = TigPubsubNodesDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigPubsubNodes> queryTigPubsubNodesList(TigPubsubNodesQuery queryBean) {
        return (List<TigPubsubNodes>) queryForList(namespace +".queryTigPubsubNodesList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigPubsubNodes tigPubsubNodes) {
        return insert(namespace +".insert", tigPubsubNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigPubsubNodes tigPubsubNodes) {
        return update(namespace +".update", tigPubsubNodes);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubNodesCount(TigPubsubNodesQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigPubsubNodesCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubNodes> queryTigPubsubNodesListWithPage(TigPubsubNodesQuery queryBean) {
        return (List<TigPubsubNodes>) queryForList(namespace +".queryTigPubsubNodesListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubNodes configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubNodes getTigPubsubNodesById(Long id) {
        return (TigPubsubNodes) queryForObject(namespace +".getTigPubsubNodesById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigPubsubNodes tigPubsubNodes) {
        int count = (Integer) queryForObject(namespace +".exist", tigPubsubNodes);
        return count > 0;
    }
}
