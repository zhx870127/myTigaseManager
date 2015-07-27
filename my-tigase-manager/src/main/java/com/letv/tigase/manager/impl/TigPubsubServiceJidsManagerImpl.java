package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
import com.letv.tigase.dao.TigPubsubServiceJidsDao;
import com.letv.tigase.manager.TigPubsubServiceJidsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubServiceJidsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubServiceJidsManagerImpl extends BaseManager implements TigPubsubServiceJidsManager {
	
    @Autowired
    private TigPubsubServiceJidsDao tigPubsubServiceJidsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubServiceJids> tigPubsubServiceJidsList) {
        boolean resultFlag = false;
        if (null != tigPubsubServiceJidsList && tigPubsubServiceJidsList.size() > 0) {
            for (TigPubsubServiceJids tigPubsubServiceJids : tigPubsubServiceJidsList) {
                resultFlag = tigPubsubServiceJidsDao.insert(tigPubsubServiceJids);
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
    public boolean insert(TigPubsubServiceJids tigPubsubServiceJids) {
        return tigPubsubServiceJidsDao.insert(tigPubsubServiceJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubServiceJids tigPubsubServiceJids) {
        return tigPubsubServiceJidsDao.update(tigPubsubServiceJids);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsList(TigPubsubServiceJidsQuery queryBean) {
        return tigPubsubServiceJidsDao.queryTigPubsubServiceJidsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsListWithPage(TigPubsubServiceJidsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubServiceJidsQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubServiceJidsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubServiceJidsDao.queryTigPubsubServiceJidsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubServiceJidsCount(TigPubsubServiceJidsQuery queryBean) {
        return tigPubsubServiceJidsDao.queryTigPubsubServiceJidsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubServiceJids tigPubsubServiceJids) {
        return tigPubsubServiceJidsDao.delete(tigPubsubServiceJids);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubServiceJids getTigPubsubServiceJidsById(Long id) {
        return tigPubsubServiceJidsDao.getTigPubsubServiceJidsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubServiceJids[] tigPubsubServiceJidss) {
        boolean resultFlag = false;
        if (null != tigPubsubServiceJidss && tigPubsubServiceJidss.length > 0) {
            for (int i = 0; i < tigPubsubServiceJidss.length; i++) {
                resultFlag = delete(tigPubsubServiceJidss[i]);
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
    public boolean exist(TigPubsubServiceJids tigPubsubServiceJids) {
        return tigPubsubServiceJidsDao.exist(tigPubsubServiceJids);
    }
}
