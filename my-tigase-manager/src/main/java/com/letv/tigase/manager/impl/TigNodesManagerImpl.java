package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;
import com.letv.tigase.dao.TigNodesDao;
import com.letv.tigase.manager.TigNodesManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigNodesManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigNodesManagerImpl extends BaseManager implements TigNodesManager {
	
    @Autowired
    private TigNodesDao tigNodesDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigNodes> tigNodesList) {
        boolean resultFlag = false;
        if (null != tigNodesList && tigNodesList.size() > 0) {
            for (TigNodes tigNodes : tigNodesList) {
                resultFlag = tigNodesDao.insert(tigNodes);
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
    public boolean insert(TigNodes tigNodes) {
        return tigNodesDao.insert(tigNodes);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigNodes tigNodes) {
        return tigNodesDao.update(tigNodes);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigNodes> queryTigNodesList(TigNodesQuery queryBean) {
        return tigNodesDao.queryTigNodesList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigNodes> queryTigNodesListWithPage(TigNodesQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigNodesQuery();
        }

        // 查询总数
        int totalItem = queryTigNodesCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigNodesDao.queryTigNodesListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigNodesCount(TigNodesQuery queryBean) {
        return tigNodesDao.queryTigNodesCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigNodes tigNodes) {
        return tigNodesDao.delete(tigNodes);
    }

    /**
     * {@inheritDoc}
     */
    public TigNodes getTigNodesById(Long id) {
        return tigNodesDao.getTigNodesById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigNodes[] tigNodess) {
        boolean resultFlag = false;
        if (null != tigNodess && tigNodess.length > 0) {
            for (int i = 0; i < tigNodess.length; i++) {
                resultFlag = delete(tigNodess[i]);
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
    public boolean exist(TigNodes tigNodes) {
        return tigNodesDao.exist(tigNodes);
    }
}
