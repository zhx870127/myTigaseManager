package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;
import com.letv.tigase.dao.TigMaJidsDao;
import com.letv.tigase.manager.TigMaJidsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigMaJidsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigMaJidsManagerImpl extends BaseManager implements TigMaJidsManager {
	
    @Autowired
    private TigMaJidsDao tigMaJidsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigMaJids> tigMaJidsList) {
        boolean resultFlag = false;
        if (null != tigMaJidsList && tigMaJidsList.size() > 0) {
            for (TigMaJids tigMaJids : tigMaJidsList) {
                resultFlag = tigMaJidsDao.insert(tigMaJids);
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
    public boolean insert(TigMaJids tigMaJids) {
        return tigMaJidsDao.insert(tigMaJids);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigMaJids tigMaJids) {
        return tigMaJidsDao.update(tigMaJids);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaJids> queryTigMaJidsList(TigMaJidsQuery queryBean) {
        return tigMaJidsDao.queryTigMaJidsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaJids> queryTigMaJidsListWithPage(TigMaJidsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigMaJidsQuery();
        }

        // 查询总数
        int totalItem = queryTigMaJidsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigMaJidsDao.queryTigMaJidsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaJidsCount(TigMaJidsQuery queryBean) {
        return tigMaJidsDao.queryTigMaJidsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaJids tigMaJids) {
        return tigMaJidsDao.delete(tigMaJids);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaJids getTigMaJidsById(Long id) {
        return tigMaJidsDao.getTigMaJidsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigMaJids[] tigMaJidss) {
        boolean resultFlag = false;
        if (null != tigMaJidss && tigMaJidss.length > 0) {
            for (int i = 0; i < tigMaJidss.length; i++) {
                resultFlag = delete(tigMaJidss[i]);
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
    public boolean exist(TigMaJids tigMaJids) {
        return tigMaJidsDao.exist(tigMaJids);
    }
}
