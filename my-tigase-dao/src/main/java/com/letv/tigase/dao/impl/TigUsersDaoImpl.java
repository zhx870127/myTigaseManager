package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigUsersDao;
import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.domain.query.TigUsersQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigUsersDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigUsersDaoImpl extends BaseDao implements TigUsersDao {
    /** namespace */
    private final String namespace = TigUsersDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigUsers> queryTigUsersList(TigUsersQuery queryBean) {
        return (List<TigUsers>) queryForList(namespace +".queryTigUsersList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigUsers tigUsers) {
        return insert(namespace +".insert", tigUsers);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigUsers tigUsers) {
        return update(namespace +".update", tigUsers);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigUsersCount(TigUsersQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigUsersCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigUsers> queryTigUsersListWithPage(TigUsersQuery queryBean) {
        return (List<TigUsers>) queryForList(namespace +".queryTigUsersListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigUsers configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigUsers getTigUsersById(Long id) {
        return (TigUsers) queryForObject(namespace +".getTigUsersById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigUsers tigUsers) {
        int count = (Integer) queryForObject(namespace +".exist", tigUsers);
        return count > 0;
    }
}
