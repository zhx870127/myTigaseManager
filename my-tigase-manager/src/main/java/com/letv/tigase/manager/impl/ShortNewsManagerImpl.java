package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.domain.query.ShortNewsQuery;
import com.letv.tigase.dao.ShortNewsDao;
import com.letv.tigase.manager.ShortNewsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ShortNewsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class ShortNewsManagerImpl extends BaseManager implements ShortNewsManager {
	
    @Autowired
    private ShortNewsDao shortNewsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ShortNews> shortNewsList) {
        boolean resultFlag = false;
        if (null != shortNewsList && shortNewsList.size() > 0) {
            for (ShortNews shortNews : shortNewsList) {
                resultFlag = shortNewsDao.insert(shortNews);
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
    public boolean insert(ShortNews shortNews) {
        return shortNewsDao.insert(shortNews);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ShortNews shortNews) {
        return shortNewsDao.update(shortNews);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShortNews> queryShortNewsList(ShortNewsQuery queryBean) {
        return shortNewsDao.queryShortNewsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShortNews> queryShortNewsListWithPage(ShortNewsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ShortNewsQuery();
        }

        // 查询总数
        int totalItem = queryShortNewsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return shortNewsDao.queryShortNewsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryShortNewsCount(ShortNewsQuery queryBean) {
        return shortNewsDao.queryShortNewsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ShortNews shortNews) {
        return shortNewsDao.delete(shortNews);
    }

    /**
     * {@inheritDoc}
     */
    public ShortNews getShortNewsById(Long id) {
        return shortNewsDao.getShortNewsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ShortNews[] shortNewss) {
        boolean resultFlag = false;
        if (null != shortNewss && shortNewss.length > 0) {
            for (int i = 0; i < shortNewss.length; i++) {
                resultFlag = delete(shortNewss[i]);
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
    public boolean exist(ShortNews shortNews) {
        return shortNewsDao.exist(shortNews);
    }
}
