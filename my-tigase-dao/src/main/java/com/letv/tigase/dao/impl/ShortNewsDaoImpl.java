package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.ShortNewsDao;
import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.domain.query.ShortNewsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ShortNewsDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class ShortNewsDaoImpl extends BaseDao implements ShortNewsDao {
    /** namespace */
    private final String namespace = ShortNewsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ShortNews> queryShortNewsList(ShortNewsQuery queryBean) {
        return (List<ShortNews>) queryForList(namespace +".queryShortNewsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ShortNews shortNews) {
        return insert(namespace +".insert", shortNews);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ShortNews shortNews) {
        return update(namespace +".update", shortNews);
    }

    /**
     * {@inheritDoc}
     */
    public int queryShortNewsCount(ShortNewsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryShortNewsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShortNews> queryShortNewsListWithPage(ShortNewsQuery queryBean) {
        return (List<ShortNews>) queryForList(namespace +".queryShortNewsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ShortNews configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ShortNews getShortNewsById(Long id) {
        return (ShortNews) queryForObject(namespace +".getShortNewsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ShortNews shortNews) {
        int count = (Integer) queryForObject(namespace +".exist", shortNews);
        return count > 0;
    }
}
