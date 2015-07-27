package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
import com.letv.tigase.dao.TigPubsubSubscriptionsDao;
import com.letv.tigase.manager.TigPubsubSubscriptionsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubSubscriptionsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubSubscriptionsManagerImpl extends BaseManager implements TigPubsubSubscriptionsManager {
	
    @Autowired
    private TigPubsubSubscriptionsDao tigPubsubSubscriptionsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubSubscriptions> tigPubsubSubscriptionsList) {
        boolean resultFlag = false;
        if (null != tigPubsubSubscriptionsList && tigPubsubSubscriptionsList.size() > 0) {
            for (TigPubsubSubscriptions tigPubsubSubscriptions : tigPubsubSubscriptionsList) {
                resultFlag = tigPubsubSubscriptionsDao.insert(tigPubsubSubscriptions);
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
    public boolean insert(TigPubsubSubscriptions tigPubsubSubscriptions) {
        return tigPubsubSubscriptionsDao.insert(tigPubsubSubscriptions);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubSubscriptions tigPubsubSubscriptions) {
        return tigPubsubSubscriptionsDao.update(tigPubsubSubscriptions);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsList(TigPubsubSubscriptionsQuery queryBean) {
        return tigPubsubSubscriptionsDao.queryTigPubsubSubscriptionsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubSubscriptions> queryTigPubsubSubscriptionsListWithPage(TigPubsubSubscriptionsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubSubscriptionsQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubSubscriptionsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubSubscriptionsDao.queryTigPubsubSubscriptionsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubSubscriptionsCount(TigPubsubSubscriptionsQuery queryBean) {
        return tigPubsubSubscriptionsDao.queryTigPubsubSubscriptionsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubSubscriptions tigPubsubSubscriptions) {
        return tigPubsubSubscriptionsDao.delete(tigPubsubSubscriptions);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubSubscriptions getTigPubsubSubscriptionsById(Long id) {
        return tigPubsubSubscriptionsDao.getTigPubsubSubscriptionsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubSubscriptions[] tigPubsubSubscriptionss) {
        boolean resultFlag = false;
        if (null != tigPubsubSubscriptionss && tigPubsubSubscriptionss.length > 0) {
            for (int i = 0; i < tigPubsubSubscriptionss.length; i++) {
                resultFlag = delete(tigPubsubSubscriptionss[i]);
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
    public boolean exist(TigPubsubSubscriptions tigPubsubSubscriptions) {
        return tigPubsubSubscriptionsDao.exist(tigPubsubSubscriptions);
    }
}
