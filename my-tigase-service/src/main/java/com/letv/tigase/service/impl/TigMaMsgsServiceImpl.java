package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
import com.letv.tigase.manager.TigMaMsgsManager;
import com.letv.tigase.service.TigMaMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigMaMsgsService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigMaMsgsServiceImpl implements TigMaMsgsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigMaMsgsServiceImpl.class);

    @Autowired
    private TigMaMsgsManager tigMaMsgsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.batchInsert")
    public boolean insert(List<TigMaMsgs> tigMaMsgsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigMaMsgsList)) {
                resultFlag = tigMaMsgsManager.insert(tigMaMsgsList);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.insert")
    public boolean insert(TigMaMsgs tigMaMsgs) {
        boolean resultFlag = false;
        try {
            if (null != tigMaMsgs) {
                if (tigMaMsgsManager.exist(tigMaMsgs)) {
                    throw new ExistedException();
                }
                resultFlag = tigMaMsgsManager.insert(tigMaMsgs);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigMaMsgsServiceImpl#insert failed, tigMaMsgs has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.update")
    public boolean update(TigMaMsgs tigMaMsgs) {
        boolean resultFlag = false;
        try {
            if (null != tigMaMsgs && null != tigMaMsgs.getMsgId()) {
                resultFlag = tigMaMsgsManager.update(tigMaMsgs);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.queryTigMaMsgsList")
    public List<TigMaMsgs> queryTigMaMsgsList(TigMaMsgsQuery queryBean) {
        List<TigMaMsgs> tigMaMsgsList = null;
        try {
            tigMaMsgsList = tigMaMsgsManager.queryTigMaMsgsList(queryBean);
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#queryTigMaMsgsList has error.", e);
        }
        return tigMaMsgsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.queryTigMaMsgsListWithPage")
    public List<TigMaMsgs> queryTigMaMsgsListWithPage(TigMaMsgsQuery queryBean, PageUtil pageUtil) {
        List<TigMaMsgs> tigMaMsgsList = null;
        try {
            tigMaMsgsList = tigMaMsgsManager.queryTigMaMsgsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#queryTigMaMsgsListWithPage has error.", e);
        }
        return tigMaMsgsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.delete")
    public boolean delete(TigMaMsgs tigMaMsgs) {
        boolean resultFlag = false;
        try {
            if (null != tigMaMsgs && null != tigMaMsgs.getMsgId()) {
                resultFlag = tigMaMsgsManager.delete(tigMaMsgs);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.batchDelete")
    public boolean delete(TigMaMsgs[] tigMaMsgss) {
        boolean resultFlag = false;
        try {
            if (null != tigMaMsgss && tigMaMsgss.length > 0) {
                resultFlag = tigMaMsgsManager.delete(tigMaMsgss);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigMaMsgsService.getTigMaMsgsById")
    public TigMaMsgs getTigMaMsgsById(Long id) {
        TigMaMsgs tigMaMsgs = null;
        try {
            if (null != id) {
                tigMaMsgs = tigMaMsgsManager.getTigMaMsgsById(id);
            } else {
                LOG.warn("TigMaMsgsServiceImpl#getTigMaMsgsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigMaMsgsServiceImpl#getTigMaMsgsById has error.", e);
        }
        return tigMaMsgs;
    }
}

