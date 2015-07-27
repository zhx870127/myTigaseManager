package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
import com.letv.tigase.manager.TigSocks5ConnectionsManager;
import com.letv.tigase.service.TigSocks5ConnectionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigSocks5ConnectionsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigSocks5ConnectionsServiceImpl implements TigSocks5ConnectionsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigSocks5ConnectionsServiceImpl.class);

    @Autowired
    private TigSocks5ConnectionsManager tigSocks5ConnectionsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.batchInsert")
    public boolean insert(List<TigSocks5Connections> tigSocks5ConnectionsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigSocks5ConnectionsList)) {
                resultFlag = tigSocks5ConnectionsManager.insert(tigSocks5ConnectionsList);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.insert")
    public boolean insert(TigSocks5Connections tigSocks5Connections) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Connections) {
                if (tigSocks5ConnectionsManager.exist(tigSocks5Connections)) {
                    throw new ExistedException();
                }
                resultFlag = tigSocks5ConnectionsManager.insert(tigSocks5Connections);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigSocks5ConnectionsServiceImpl#insert failed, tigSocks5Connections has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.update")
    public boolean update(TigSocks5Connections tigSocks5Connections) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Connections && null != tigSocks5Connections.getConnId()) {
                resultFlag = tigSocks5ConnectionsManager.update(tigSocks5Connections);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.queryTigSocks5ConnectionsList")
    public List<TigSocks5Connections> queryTigSocks5ConnectionsList(TigSocks5ConnectionsQuery queryBean) {
        List<TigSocks5Connections> tigSocks5ConnectionsList = null;
        try {
            tigSocks5ConnectionsList = tigSocks5ConnectionsManager.queryTigSocks5ConnectionsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#queryTigSocks5ConnectionsList has error.", e);
        }
        return tigSocks5ConnectionsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.queryTigSocks5ConnectionsListWithPage")
    public List<TigSocks5Connections> queryTigSocks5ConnectionsListWithPage(TigSocks5ConnectionsQuery queryBean, PageUtil pageUtil) {
        List<TigSocks5Connections> tigSocks5ConnectionsList = null;
        try {
            tigSocks5ConnectionsList = tigSocks5ConnectionsManager.queryTigSocks5ConnectionsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#queryTigSocks5ConnectionsListWithPage has error.", e);
        }
        return tigSocks5ConnectionsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.delete")
    public boolean delete(TigSocks5Connections tigSocks5Connections) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Connections && null != tigSocks5Connections.getConnId()) {
                resultFlag = tigSocks5ConnectionsManager.delete(tigSocks5Connections);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.batchDelete")
    public boolean delete(TigSocks5Connections[] tigSocks5Connectionss) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Connectionss && tigSocks5Connectionss.length > 0) {
                resultFlag = tigSocks5ConnectionsManager.delete(tigSocks5Connectionss);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5ConnectionsService.getTigSocks5ConnectionsById")
    public TigSocks5Connections getTigSocks5ConnectionsById(Long id) {
        TigSocks5Connections tigSocks5Connections = null;
        try {
            if (null != id) {
                tigSocks5Connections = tigSocks5ConnectionsManager.getTigSocks5ConnectionsById(id);
            } else {
                LOG.warn("TigSocks5ConnectionsServiceImpl#getTigSocks5ConnectionsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5ConnectionsServiceImpl#getTigSocks5ConnectionsById has error.", e);
        }
        return tigSocks5Connections;
    }
}

