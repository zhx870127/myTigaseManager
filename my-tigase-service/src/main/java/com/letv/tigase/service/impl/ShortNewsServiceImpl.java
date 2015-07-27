package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.domain.query.ShortNewsQuery;
import com.letv.tigase.manager.ShortNewsManager;
import com.letv.tigase.service.ShortNewsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ShortNewsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class ShortNewsServiceImpl implements ShortNewsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ShortNewsServiceImpl.class);

    @Autowired
    private ShortNewsManager shortNewsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.batchInsert")
    public boolean insert(List<ShortNews> shortNewsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(shortNewsList)) {
                resultFlag = shortNewsManager.insert(shortNewsList);
            } else {
                LOG.warn("ShortNewsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.insert")
    public boolean insert(ShortNews shortNews) {
        boolean resultFlag = false;
        try {
            if (null != shortNews) {
                if (shortNewsManager.exist(shortNews)) {
                    throw new ExistedException();
                }
                resultFlag = shortNewsManager.insert(shortNews);
            } else {
                LOG.warn("ShortNewsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ShortNewsServiceImpl#insert failed, shortNews has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.update")
    public boolean update(ShortNews shortNews) {
        boolean resultFlag = false;
        try {
            if (null != shortNews && null != shortNews.getSnid()) {
                resultFlag = shortNewsManager.update(shortNews);
            } else {
                LOG.warn("ShortNewsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.queryShortNewsList")
    public List<ShortNews> queryShortNewsList(ShortNewsQuery queryBean) {
        List<ShortNews> shortNewsList = null;
        try {
            shortNewsList = shortNewsManager.queryShortNewsList(queryBean);
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#queryShortNewsList has error.", e);
        }
        return shortNewsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.queryShortNewsListWithPage")
    public List<ShortNews> queryShortNewsListWithPage(ShortNewsQuery queryBean, PageUtil pageUtil) {
        List<ShortNews> shortNewsList = null;
        try {
            shortNewsList = shortNewsManager.queryShortNewsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#queryShortNewsListWithPage has error.", e);
        }
        return shortNewsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.delete")
    public boolean delete(ShortNews shortNews) {
        boolean resultFlag = false;
        try {
            if (null != shortNews && null != shortNews.getSnid()) {
                resultFlag = shortNewsManager.delete(shortNews);
            } else {
                LOG.warn("ShortNewsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.batchDelete")
    public boolean delete(ShortNews[] shortNewss) {
        boolean resultFlag = false;
        try {
            if (null != shortNewss && shortNewss.length > 0) {
                resultFlag = shortNewsManager.delete(shortNewss);
            } else {
                LOG.warn("ShortNewsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShortNewsService.getShortNewsById")
    public ShortNews getShortNewsById(Long id) {
        ShortNews shortNews = null;
        try {
            if (null != id) {
                shortNews = shortNewsManager.getShortNewsById(id);
            } else {
                LOG.warn("ShortNewsServiceImpl#getShortNewsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShortNewsServiceImpl#getShortNewsById has error.", e);
        }
        return shortNews;
    }
}

