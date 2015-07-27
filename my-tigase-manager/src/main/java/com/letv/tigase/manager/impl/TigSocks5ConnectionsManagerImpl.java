package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
import com.letv.tigase.dao.TigSocks5ConnectionsDao;
import com.letv.tigase.manager.TigSocks5ConnectionsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigSocks5ConnectionsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigSocks5ConnectionsManagerImpl extends BaseManager implements TigSocks5ConnectionsManager {
	
    @Autowired
    private TigSocks5ConnectionsDao tigSocks5ConnectionsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigSocks5Connections> tigSocks5ConnectionsList) {
        boolean resultFlag = false;
        if (null != tigSocks5ConnectionsList && tigSocks5ConnectionsList.size() > 0) {
            for (TigSocks5Connections tigSocks5Connections : tigSocks5ConnectionsList) {
                resultFlag = tigSocks5ConnectionsDao.insert(tigSocks5Connections);
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
    public boolean insert(TigSocks5Connections tigSocks5Connections) {
        return tigSocks5ConnectionsDao.insert(tigSocks5Connections);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigSocks5Connections tigSocks5Connections) {
        return tigSocks5ConnectionsDao.update(tigSocks5Connections);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsList(TigSocks5ConnectionsQuery queryBean) {
        return tigSocks5ConnectionsDao.queryTigSocks5ConnectionsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsListWithPage(TigSocks5ConnectionsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigSocks5ConnectionsQuery();
        }

        // 查询总数
        int totalItem = queryTigSocks5ConnectionsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigSocks5ConnectionsDao.queryTigSocks5ConnectionsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigSocks5ConnectionsCount(TigSocks5ConnectionsQuery queryBean) {
        return tigSocks5ConnectionsDao.queryTigSocks5ConnectionsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigSocks5Connections tigSocks5Connections) {
        return tigSocks5ConnectionsDao.delete(tigSocks5Connections);
    }

    /**
     * {@inheritDoc}
     */
    public TigSocks5Connections getTigSocks5ConnectionsById(Long id) {
        return tigSocks5ConnectionsDao.getTigSocks5ConnectionsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigSocks5Connections[] tigSocks5Connectionss) {
        boolean resultFlag = false;
        if (null != tigSocks5Connectionss && tigSocks5Connectionss.length > 0) {
            for (int i = 0; i < tigSocks5Connectionss.length; i++) {
                resultFlag = delete(tigSocks5Connectionss[i]);
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
    public boolean exist(TigSocks5Connections tigSocks5Connections) {
        return tigSocks5ConnectionsDao.exist(tigSocks5Connections);
    }
}
