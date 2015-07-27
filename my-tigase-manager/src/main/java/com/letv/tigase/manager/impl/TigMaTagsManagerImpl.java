package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.domain.query.TigMaTagsQuery;
import com.letv.tigase.dao.TigMaTagsDao;
import com.letv.tigase.manager.TigMaTagsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigMaTagsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigMaTagsManagerImpl extends BaseManager implements TigMaTagsManager {
	
    @Autowired
    private TigMaTagsDao tigMaTagsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigMaTags> tigMaTagsList) {
        boolean resultFlag = false;
        if (null != tigMaTagsList && tigMaTagsList.size() > 0) {
            for (TigMaTags tigMaTags : tigMaTagsList) {
                resultFlag = tigMaTagsDao.insert(tigMaTags);
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
    public boolean insert(TigMaTags tigMaTags) {
        return tigMaTagsDao.insert(tigMaTags);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigMaTags tigMaTags) {
        return tigMaTagsDao.update(tigMaTags);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaTags> queryTigMaTagsList(TigMaTagsQuery queryBean) {
        return tigMaTagsDao.queryTigMaTagsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaTags> queryTigMaTagsListWithPage(TigMaTagsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigMaTagsQuery();
        }

        // 查询总数
        int totalItem = queryTigMaTagsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigMaTagsDao.queryTigMaTagsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaTagsCount(TigMaTagsQuery queryBean) {
        return tigMaTagsDao.queryTigMaTagsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaTags tigMaTags) {
        return tigMaTagsDao.delete(tigMaTags);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaTags getTigMaTagsById(Long id) {
        return tigMaTagsDao.getTigMaTagsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigMaTags[] tigMaTagss) {
        boolean resultFlag = false;
        if (null != tigMaTagss && tigMaTagss.length > 0) {
            for (int i = 0; i < tigMaTagss.length; i++) {
                resultFlag = delete(tigMaTagss[i]);
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
    public boolean exist(TigMaTags tigMaTags) {
        return tigMaTagsDao.exist(tigMaTags);
    }
}
