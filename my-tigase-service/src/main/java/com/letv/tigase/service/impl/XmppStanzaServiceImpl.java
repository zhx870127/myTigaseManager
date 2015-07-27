package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;
import com.letv.tigase.manager.XmppStanzaManager;
import com.letv.tigase.service.XmppStanzaService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * XmppStanzaService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class XmppStanzaServiceImpl implements XmppStanzaService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(XmppStanzaServiceImpl.class);

    @Autowired
    private XmppStanzaManager xmppStanzaManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.batchInsert")
    public boolean insert(List<XmppStanza> xmppStanzaList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(xmppStanzaList)) {
                resultFlag = xmppStanzaManager.insert(xmppStanzaList);
            } else {
                LOG.warn("XmppStanzaServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.insert")
    public boolean insert(XmppStanza xmppStanza) {
        boolean resultFlag = false;
        try {
            if (null != xmppStanza) {
                if (xmppStanzaManager.exist(xmppStanza)) {
                    throw new ExistedException();
                }
                resultFlag = xmppStanzaManager.insert(xmppStanza);
            } else {
                LOG.warn("XmppStanzaServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("XmppStanzaServiceImpl#insert failed, xmppStanza has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.update")
    public boolean update(XmppStanza xmppStanza) {
        boolean resultFlag = false;
        try {
            if (null != xmppStanza && null != xmppStanza.getId()) {
                resultFlag = xmppStanzaManager.update(xmppStanza);
            } else {
                LOG.warn("XmppStanzaServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.queryXmppStanzaList")
    public List<XmppStanza> queryXmppStanzaList(XmppStanzaQuery queryBean) {
        List<XmppStanza> xmppStanzaList = null;
        try {
            xmppStanzaList = xmppStanzaManager.queryXmppStanzaList(queryBean);
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#queryXmppStanzaList has error.", e);
        }
        return xmppStanzaList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.queryXmppStanzaListWithPage")
    public List<XmppStanza> queryXmppStanzaListWithPage(XmppStanzaQuery queryBean, PageUtil pageUtil) {
        List<XmppStanza> xmppStanzaList = null;
        try {
            xmppStanzaList = xmppStanzaManager.queryXmppStanzaListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#queryXmppStanzaListWithPage has error.", e);
        }
        return xmppStanzaList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.delete")
    public boolean delete(XmppStanza xmppStanza) {
        boolean resultFlag = false;
        try {
            if (null != xmppStanza && null != xmppStanza.getId()) {
                resultFlag = xmppStanzaManager.delete(xmppStanza);
            } else {
                LOG.warn("XmppStanzaServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.batchDelete")
    public boolean delete(XmppStanza[] xmppStanzas) {
        boolean resultFlag = false;
        try {
            if (null != xmppStanzas && xmppStanzas.length > 0) {
                resultFlag = xmppStanzaManager.delete(xmppStanzas);
            } else {
                LOG.warn("XmppStanzaServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "XmppStanzaService.getXmppStanzaById")
    public XmppStanza getXmppStanzaById(Long id) {
        XmppStanza xmppStanza = null;
        try {
            if (null != id) {
                xmppStanza = xmppStanzaManager.getXmppStanzaById(id);
            } else {
                LOG.warn("XmppStanzaServiceImpl#getXmppStanzaById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("XmppStanzaServiceImpl#getXmppStanzaById has error.", e);
        }
        return xmppStanza;
    }
}

