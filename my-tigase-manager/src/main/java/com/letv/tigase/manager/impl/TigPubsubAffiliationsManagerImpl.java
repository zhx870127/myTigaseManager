package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;
import com.letv.tigase.dao.TigPubsubAffiliationsDao;
import com.letv.tigase.manager.TigPubsubAffiliationsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubAffiliationsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubAffiliationsManagerImpl extends BaseManager implements TigPubsubAffiliationsManager {
	
    @Autowired
    private TigPubsubAffiliationsDao tigPubsubAffiliationsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubAffiliations> tigPubsubAffiliationsList) {
        boolean resultFlag = false;
        if (null != tigPubsubAffiliationsList && tigPubsubAffiliationsList.size() > 0) {
            for (TigPubsubAffiliations tigPubsubAffiliations : tigPubsubAffiliationsList) {
                resultFlag = tigPubsubAffiliationsDao.insert(tigPubsubAffiliations);
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
    public boolean insert(TigPubsubAffiliations tigPubsubAffiliations) {
        return tigPubsubAffiliationsDao.insert(tigPubsubAffiliations);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubAffiliations tigPubsubAffiliations) {
        return tigPubsubAffiliationsDao.update(tigPubsubAffiliations);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsList(TigPubsubAffiliationsQuery queryBean) {
        return tigPubsubAffiliationsDao.queryTigPubsubAffiliationsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsListWithPage(TigPubsubAffiliationsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubAffiliationsQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubAffiliationsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubAffiliationsDao.queryTigPubsubAffiliationsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubAffiliationsCount(TigPubsubAffiliationsQuery queryBean) {
        return tigPubsubAffiliationsDao.queryTigPubsubAffiliationsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubAffiliations tigPubsubAffiliations) {
        return tigPubsubAffiliationsDao.delete(tigPubsubAffiliations);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubAffiliations getTigPubsubAffiliationsById(Long id) {
        return tigPubsubAffiliationsDao.getTigPubsubAffiliationsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubAffiliations[] tigPubsubAffiliationss) {
        boolean resultFlag = false;
        if (null != tigPubsubAffiliationss && tigPubsubAffiliationss.length > 0) {
            for (int i = 0; i < tigPubsubAffiliationss.length; i++) {
                resultFlag = delete(tigPubsubAffiliationss[i]);
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
    public boolean exist(TigPubsubAffiliations tigPubsubAffiliations) {
        return tigPubsubAffiliationsDao.exist(tigPubsubAffiliations);
    }
}
