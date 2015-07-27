package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;
import com.letv.tigase.dao.TigPubsubJidsDao;
import com.letv.tigase.manager.TigPubsubJidsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigPubsubJidsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigPubsubJidsManagerImpl extends BaseManager implements TigPubsubJidsManager {
	
    @Autowired
    private TigPubsubJidsDao tigPubsubJidsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigPubsubJids> tigPubsubJidsList) {
        boolean resultFlag = false;
        if (null != tigPubsubJidsList && tigPubsubJidsList.size() > 0) {
            for (TigPubsubJids tigPubsubJids : tigPubsubJidsList) {
                resultFlag = tigPubsubJidsDao.insert(tigPubsubJids);
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
    public boolean insert(TigPubsubJids tigPubsubJids) {
        return tigPubsubJidsDao.insert(tigPubsubJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigPubsubJids tigPubsubJids) {
        return tigPubsubJidsDao.update(tigPubsubJids);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubJids> queryTigPubsubJidsList(TigPubsubJidsQuery queryBean) {
        return tigPubsubJidsDao.queryTigPubsubJidsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigPubsubJids> queryTigPubsubJidsListWithPage(TigPubsubJidsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigPubsubJidsQuery();
        }

        // 查询总数
        int totalItem = queryTigPubsubJidsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigPubsubJidsDao.queryTigPubsubJidsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigPubsubJidsCount(TigPubsubJidsQuery queryBean) {
        return tigPubsubJidsDao.queryTigPubsubJidsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigPubsubJids tigPubsubJids) {
        return tigPubsubJidsDao.delete(tigPubsubJids);
    }

    /**
     * {@inheritDoc}
     */
    public TigPubsubJids getTigPubsubJidsById(Long id) {
        return tigPubsubJidsDao.getTigPubsubJidsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigPubsubJids[] tigPubsubJidss) {
        boolean resultFlag = false;
        if (null != tigPubsubJidss && tigPubsubJidss.length > 0) {
            for (int i = 0; i < tigPubsubJidss.length; i++) {
                resultFlag = delete(tigPubsubJidss[i]);
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
    public boolean exist(TigPubsubJids tigPubsubJids) {
        return tigPubsubJidsDao.exist(tigPubsubJids);
    }
}
