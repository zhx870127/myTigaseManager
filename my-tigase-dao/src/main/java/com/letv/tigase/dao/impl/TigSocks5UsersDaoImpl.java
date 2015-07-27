package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.TigSocks5UsersDao;
import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TigSocks5UsersDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class TigSocks5UsersDaoImpl extends BaseDao implements TigSocks5UsersDao {
    /** namespace */
    private final String namespace = TigSocks5UsersDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Users> queryTigSocks5UsersList(TigSocks5UsersQuery queryBean) {
        return (List<TigSocks5Users>) queryForList(namespace +".queryTigSocks5UsersList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TigSocks5Users tigSocks5Users) {
        return insert(namespace +".insert", tigSocks5Users);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TigSocks5Users tigSocks5Users) {
        return update(namespace +".update", tigSocks5Users);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigSocks5UsersCount(TigSocks5UsersQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTigSocks5UsersCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Users> queryTigSocks5UsersListWithPage(TigSocks5UsersQuery queryBean) {
        return (List<TigSocks5Users>) queryForList(namespace +".queryTigSocks5UsersListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigSocks5Users configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TigSocks5Users getTigSocks5UsersById(Long id) {
        return (TigSocks5Users) queryForObject(namespace +".getTigSocks5UsersById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TigSocks5Users tigSocks5Users) {
        int count = (Integer) queryForObject(namespace +".exist", tigSocks5Users);
        return count > 0;
    }
}
