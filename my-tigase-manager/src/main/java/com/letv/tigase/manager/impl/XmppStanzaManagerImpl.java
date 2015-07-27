package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;
import com.letv.tigase.dao.XmppStanzaDao;
import com.letv.tigase.manager.XmppStanzaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * XmppStanzaManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class XmppStanzaManagerImpl extends BaseManager implements XmppStanzaManager {
	
    @Autowired
    private XmppStanzaDao xmppStanzaDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<XmppStanza> xmppStanzaList) {
        boolean resultFlag = false;
        if (null != xmppStanzaList && xmppStanzaList.size() > 0) {
            for (XmppStanza xmppStanza : xmppStanzaList) {
                resultFlag = xmppStanzaDao.insert(xmppStanza);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(XmppStanza xmppStanza) {
        return xmppStanzaDao.insert(xmppStanza);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final XmppStanza xmppStanza) {
        return xmppStanzaDao.update(xmppStanza);
    }

    /**
     * {@inheritDoc}
     */
    public List<XmppStanza> queryXmppStanzaList(XmppStanzaQuery queryBean) {
        return xmppStanzaDao.queryXmppStanzaList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<XmppStanza> queryXmppStanzaListWithPage(XmppStanzaQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new XmppStanzaQuery();
        }

        // 查询总数
        int totalItem = queryXmppStanzaCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return xmppStanzaDao.queryXmppStanzaListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryXmppStanzaCount(XmppStanzaQuery queryBean) {
        return xmppStanzaDao.queryXmppStanzaCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(XmppStanza xmppStanza) {
        return xmppStanzaDao.delete(xmppStanza);
    }

    /**
     * {@inheritDoc}
     */
    public XmppStanza getXmppStanzaById(Long id) {
        return xmppStanzaDao.getXmppStanzaById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final XmppStanza[] xmppStanzas) {
        boolean resultFlag = false;
        if (null != xmppStanzas && xmppStanzas.length > 0) {
            for (int i = 0; i < xmppStanzas.length; i++) {
                resultFlag = delete(xmppStanzas[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(XmppStanza xmppStanza) {
        return xmppStanzaDao.exist(xmppStanza);
    }
}
