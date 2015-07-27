package com.letv.tigase.dao.impl;

import com.letv.common.dao.mybatis.BaseDao;
import com.letv.tigase.dao.XmppStanzaDao;
import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * XmppStanzaDAO实现类<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
@Repository
public class XmppStanzaDaoImpl extends BaseDao implements XmppStanzaDao {
    /** namespace */
    private final String namespace = XmppStanzaDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<XmppStanza> queryXmppStanzaList(XmppStanzaQuery queryBean) {
        return (List<XmppStanza>) queryForList(namespace +".queryXmppStanzaList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(XmppStanza xmppStanza) {
        return insert(namespace +".insert", xmppStanza);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(XmppStanza xmppStanza) {
        return update(namespace +".update", xmppStanza);
    }

    /**
     * {@inheritDoc}
     */
    public int queryXmppStanzaCount(XmppStanzaQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryXmppStanzaCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<XmppStanza> queryXmppStanzaListWithPage(XmppStanzaQuery queryBean) {
        return (List<XmppStanza>) queryForList(namespace +".queryXmppStanzaListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(XmppStanza configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public XmppStanza getXmppStanzaById(Long id) {
        return (XmppStanza) queryForObject(namespace +".getXmppStanzaById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(XmppStanza xmppStanza) {
        int count = (Integer) queryForObject(namespace +".exist", xmppStanza);
        return count > 0;
    }
}
