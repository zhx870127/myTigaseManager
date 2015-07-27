package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigMaMsgsDao;
import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigMaMsgsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigMaMsgsDaoImpl extends BaseDao implements TigMaMsgsDao {
    /** namespace */
    private final String namespace = TigMaMsgsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigMaMsgs> queryTigMaMsgsList(TigMaMsgsQuery queryBean) {
        return (List<TigMaMsgs>) queryForList(namespace +".queryTigMaMsgsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigMaMsgs tigMaMsgs) {
        return insert(namespace +".insert", tigMaMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigMaMsgs tigMaMsgs) {
        return update(namespace +".update", tigMaMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaMsgsCount(TigMaMsgsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigMaMsgsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaMsgs> queryTigMaMsgsListWithPage(TigMaMsgsQuery queryBean) {
        return (List<TigMaMsgs>) queryForList(namespace +".queryTigMaMsgsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaMsgs configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaMsgs getTigMaMsgsById(Long id) {
        return (TigMaMsgs) queryForObject(namespace +".getTigMaMsgsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigMaMsgs tigMaMsgs) {
        int count = (Integer) queryForObject(namespace +".exist", tigMaMsgs);
        return count > 0;
    }
}
