package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;
import com.letv.tigase.manager.TigPubsubItemsManager;
import com.letv.tigase.service.TigPubsubItemsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigPubsubItemsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigPubsubItemsServiceImpl implements TigPubsubItemsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigPubsubItemsServiceImpl.class);

    @Autowired
    private TigPubsubItemsManager tigPubsubItemsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.batchInsert")
    public boolean insert(List<TigPubsubItems> tigPubsubItemsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigPubsubItemsList)) {
                resultFlag = tigPubsubItemsManager.insert(tigPubsubItemsList);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.insert")
    public boolean insert(TigPubsubItems tigPubsubItems) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubItems) {
                if (tigPubsubItemsManager.exist(tigPubsubItems)) {
                    throw new ExistedException();
                }
                resultFlag = tigPubsubItemsManager.insert(tigPubsubItems);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigPubsubItemsServiceImpl#insert failed, tigPubsubItems has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.update")
    public boolean update(TigPubsubItems tigPubsubItems) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubItems && null != tigPubsubItems.getIdSha1()) {
                resultFlag = tigPubsubItemsManager.update(tigPubsubItems);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.queryTigPubsubItemsList")
    public List<TigPubsubItems> queryTigPubsubItemsList(TigPubsubItemsQuery queryBean) {
        List<TigPubsubItems> tigPubsubItemsList = null;
        try {
            tigPubsubItemsList = tigPubsubItemsManager.queryTigPubsubItemsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#queryTigPubsubItemsList has error.", e);
        }
        return tigPubsubItemsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.queryTigPubsubItemsListWithPage")
    public List<TigPubsubItems> queryTigPubsubItemsListWithPage(TigPubsubItemsQuery queryBean, PageUtil pageUtil) {
        List<TigPubsubItems> tigPubsubItemsList = null;
        try {
            tigPubsubItemsList = tigPubsubItemsManager.queryTigPubsubItemsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#queryTigPubsubItemsListWithPage has error.", e);
        }
        return tigPubsubItemsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.delete")
    public boolean delete(TigPubsubItems tigPubsubItems) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubItems && null != tigPubsubItems.getIdSha1()) {
                resultFlag = tigPubsubItemsManager.delete(tigPubsubItems);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.batchDelete")
    public boolean delete(TigPubsubItems[] tigPubsubItemss) {
        boolean resultFlag = false;
        try {
            if (null != tigPubsubItemss && tigPubsubItemss.length > 0) {
                resultFlag = tigPubsubItemsManager.delete(tigPubsubItemss);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigPubsubItemsService.getTigPubsubItemsById")
    public TigPubsubItems getTigPubsubItemsById(String id) {
        TigPubsubItems tigPubsubItems = null;
        try {
            if (null != id) {
                tigPubsubItems = tigPubsubItemsManager.getTigPubsubItemsById(id);
            } else {
                LOG.warn("TigPubsubItemsServiceImpl#getTigPubsubItemsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigPubsubItemsServiceImpl#getTigPubsubItemsById has error.", e);
        }
        return tigPubsubItems;
    }
}

