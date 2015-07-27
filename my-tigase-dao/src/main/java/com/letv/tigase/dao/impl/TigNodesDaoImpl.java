package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigNodesDao;
import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigNodesDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigNodesDaoImpl extends BaseDao implements TigNodesDao {
    /** namespace */
    private final String namespace = TigNodesDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigNodes> queryTigNodesList(TigNodesQuery queryBean) {
        return (List<TigNodes>) queryForList(namespace +".queryTigNodesList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigNodes tigNodes) {
        return insert(namespace +".insert", tigNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigNodes tigNodes) {
        return update(namespace +".update", tigNodes);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigNodesCount(TigNodesQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigNodesCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigNodes> queryTigNodesListWithPage(TigNodesQuery queryBean) {
        return (List<TigNodes>) queryForList(namespace +".queryTigNodesListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigNodes configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigNodes getTigNodesById(Long id) {
        return (TigNodes) queryForObject(namespace +".getTigNodesById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigNodes tigNodes) {
        int count = (Integer) queryForObject(namespace +".exist", tigNodes);
        return count > 0;
    }
}
