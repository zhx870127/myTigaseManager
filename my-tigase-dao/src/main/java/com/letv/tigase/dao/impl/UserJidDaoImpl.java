package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.UserJidDao;
import com.letv.tigase.domain.UserJid;
import com.letv.tigase.domain.query.UserJidQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserJidDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class UserJidDaoImpl extends BaseDao implements UserJidDao {
    /** namespace */
    private final String namespace = UserJidDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserJid> queryUserJidList(UserJidQuery queryBean) {
        return (List<UserJid>) queryForList(namespace +".queryUserJidList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserJid userJid) {
        return insert(namespace +".insert", userJid);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserJid userJid) {
        return update(namespace +".update", userJid);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserJidCount(UserJidQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserJidCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserJid> queryUserJidListWithPage(UserJidQuery queryBean) {
        return (List<UserJid>) queryForList(namespace +".queryUserJidListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserJid configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserJid getUserJidById(Long id) {
        return (UserJid) queryForObject(namespace +".getUserJidById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserJid userJid) {
        int count = (Integer) queryForObject(namespace +".exist", userJid);
        return count > 0;
    }
}
