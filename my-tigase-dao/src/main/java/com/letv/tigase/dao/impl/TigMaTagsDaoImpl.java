package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigMaTagsDao;
import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.domain.query.TigMaTagsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigMaTagsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigMaTagsDaoImpl extends BaseDao implements TigMaTagsDao {
    /** namespace */
    private final String namespace = TigMaTagsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigMaTags> queryTigMaTagsList(TigMaTagsQuery queryBean) {
        return (List<TigMaTags>) queryForList(namespace +".queryTigMaTagsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigMaTags tigMaTags) {
        return insert(namespace +".insert", tigMaTags);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigMaTags tigMaTags) {
        return update(namespace +".update", tigMaTags);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaTagsCount(TigMaTagsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigMaTagsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaTags> queryTigMaTagsListWithPage(TigMaTagsQuery queryBean) {
        return (List<TigMaTags>) queryForList(namespace +".queryTigMaTagsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaTags configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaTags getTigMaTagsById(Long id) {
        return (TigMaTags) queryForObject(namespace +".getTigMaTagsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigMaTags tigMaTags) {
        int count = (Integer) queryForObject(namespace +".exist", tigMaTags);
        return count > 0;
    }
}
