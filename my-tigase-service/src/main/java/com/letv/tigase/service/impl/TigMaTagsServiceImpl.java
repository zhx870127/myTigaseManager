package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.domain.query.TigMaTagsQuery;
import com.letv.tigase.manager.TigMaTagsManager;
import com.letv.tigase.service.TigMaTagsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigMaTagsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigMaTagsServiceImpl implements TigMaTagsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigMaTagsServiceImpl.class);

    @Autowired
    private TigMaTagsManager tigMaTagsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.batchInsert")
    public boolean insert(List<TigMaTags> tigMaTagsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigMaTagsList)) {
                resultFlag = tigMaTagsManager.insert(tigMaTagsList);
            } else {
                LOG.warn("TigMaTagsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.insert")
    public boolean insert(TigMaTags tigMaTags) {
        boolean resultFlag = false;
        try {
            if (null != tigMaTags) {
                if (tigMaTagsManager.exist(tigMaTags)) {
                    throw new ExistedException();
                }
                resultFlag = tigMaTagsManager.insert(tigMaTags);
            } else {
                LOG.warn("TigMaTagsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigMaTagsServiceImpl#insert failed, tigMaTags has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.update")
    public boolean update(TigMaTags tigMaTags) {
        boolean resultFlag = false;
        try {
            if (null != tigMaTags && null != tigMaTags.getTagId()) {
                resultFlag = tigMaTagsManager.update(tigMaTags);
            } else {
                LOG.warn("TigMaTagsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.queryTigMaTagsList")
    public List<TigMaTags> queryTigMaTagsList(TigMaTagsQuery queryBean) {
        List<TigMaTags> tigMaTagsList = null;
        try {
            tigMaTagsList = tigMaTagsManager.queryTigMaTagsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#queryTigMaTagsList has error.", e);
        }
        return tigMaTagsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.queryTigMaTagsListWithPage")
    public List<TigMaTags> queryTigMaTagsListWithPage(TigMaTagsQuery queryBean, PageUtil pageUtil) {
        List<TigMaTags> tigMaTagsList = null;
        try {
            tigMaTagsList = tigMaTagsManager.queryTigMaTagsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#queryTigMaTagsListWithPage has error.", e);
        }
        return tigMaTagsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.delete")
    public boolean delete(TigMaTags tigMaTags) {
        boolean resultFlag = false;
        try {
            if (null != tigMaTags && null != tigMaTags.getTagId()) {
                resultFlag = tigMaTagsManager.delete(tigMaTags);
            } else {
                LOG.warn("TigMaTagsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.batchDelete")
    public boolean delete(TigMaTags[] tigMaTagss) {
        boolean resultFlag = false;
        try {
            if (null != tigMaTagss && tigMaTagss.length > 0) {
                resultFlag = tigMaTagsManager.delete(tigMaTagss);
            } else {
                LOG.warn("TigMaTagsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaTagsService.getTigMaTagsById")
    public TigMaTags getTigMaTagsById(Long id) {
        TigMaTags tigMaTags = null;
        try {
            if (null != id) {
                tigMaTags = tigMaTagsManager.getTigMaTagsById(id);
            } else {
                LOG.warn("TigMaTagsServiceImpl#getTigMaTagsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaTagsServiceImpl#getTigMaTagsById has error.", e);
        }
        return tigMaTags;
    }
}

