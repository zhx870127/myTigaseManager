package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
import com.letv.tigase.dao.TigPubsubNodesDao;
import com.letv.tigase.manager.TigPubsubNodesManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubNodesManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubNodesManagerImpl extends BaseManager implements TigPubsubNodesManager {
	
    @Autowired
    private TigPubsubNodesDao tigPubsubNodesDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubNodes> tigPubsubNodesList) {
        boolean resultFlag = false;
        if (null != tigPubsubNodesList && tigPubsubNodesList.size() > 0) {
            for (TigPubsubNodes tigPubsubNodes : tigPubsubNodesList) {
                resultFlag = tigPubsubNodesDao.insert(tigPubsubNodes);
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
    public boolean insert(TigPubsubNodes tigPubsubNodes) {
        return tigPubsubNodesDao.insert(tigPubsubNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubNodes tigPubsubNodes) {
        return tigPubsubNodesDao.update(tigPubsubNodes);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubNodes> queryTigPubsubNodesList(TigPubsubNodesQuery queryBean) {
        return tigPubsubNodesDao.queryTigPubsubNodesList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubNodes> queryTigPubsubNodesListWithPage(TigPubsubNodesQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubNodesQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubNodesCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubNodesDao.queryTigPubsubNodesListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubNodesCount(TigPubsubNodesQuery queryBean) {
        return tigPubsubNodesDao.queryTigPubsubNodesCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubNodes tigPubsubNodes) {
        return tigPubsubNodesDao.delete(tigPubsubNodes);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubNodes getTigPubsubNodesById(Long id) {
        return tigPubsubNodesDao.getTigPubsubNodesById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubNodes[] tigPubsubNodess) {
        boolean resultFlag = false;
        if (null != tigPubsubNodess && tigPubsubNodess.length > 0) {
            for (int i = 0; i < tigPubsubNodess.length; i++) {
                resultFlag = delete(tigPubsubNodess[i]);
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
    public boolean exist(TigPubsubNodes tigPubsubNodes) {
        return tigPubsubNodesDao.exist(tigPubsubNodes);
    }
}
