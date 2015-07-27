package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;
import com.letv.tigase.dao.TigPubsubItemsDao;
import com.letv.tigase.manager.TigPubsubItemsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubItemsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubItemsManagerImpl extends BaseManager implements TigPubsubItemsManager {
	
    @Autowired
    private TigPubsubItemsDao tigPubsubItemsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubItems> tigPubsubItemsList) {
        boolean resultFlag = false;
        if (null != tigPubsubItemsList && tigPubsubItemsList.size() > 0) {
            for (TigPubsubItems tigPubsubItems : tigPubsubItemsList) {
                resultFlag = tigPubsubItemsDao.insert(tigPubsubItems);
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
    public boolean insert(TigPubsubItems tigPubsubItems) {
        return tigPubsubItemsDao.insert(tigPubsubItems);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubItems tigPubsubItems) {
        return tigPubsubItemsDao.update(tigPubsubItems);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubItems> queryTigPubsubItemsList(TigPubsubItemsQuery queryBean) {
        return tigPubsubItemsDao.queryTigPubsubItemsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubItems> queryTigPubsubItemsListWithPage(TigPubsubItemsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubItemsQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubItemsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubItemsDao.queryTigPubsubItemsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubItemsCount(TigPubsubItemsQuery queryBean) {
        return tigPubsubItemsDao.queryTigPubsubItemsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubItems tigPubsubItems) {
        return tigPubsubItemsDao.delete(tigPubsubItems);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubItems getTigPubsubItemsById(String id) {
        return tigPubsubItemsDao.getTigPubsubItemsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubItems[] tigPubsubItemss) {
        boolean resultFlag = false;
        if (null != tigPubsubItemss && tigPubsubItemss.length > 0) {
            for (int i = 0; i < tigPubsubItemss.length; i++) {
                resultFlag = delete(tigPubsubItemss[i]);
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
    public boolean exist(TigPubsubItems tigPubsubItems) {
        return tigPubsubItemsDao.exist(tigPubsubItems);
    }
}
