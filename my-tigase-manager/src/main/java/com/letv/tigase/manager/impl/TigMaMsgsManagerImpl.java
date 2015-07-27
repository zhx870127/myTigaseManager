package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
import com.letv.tigase.dao.TigMaMsgsDao;
import com.letv.tigase.manager.TigMaMsgsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigMaMsgsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigMaMsgsManagerImpl extends BaseManager implements TigMaMsgsManager {
	
    @Autowired
    private TigMaMsgsDao tigMaMsgsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigMaMsgs> tigMaMsgsList) {
        boolean resultFlag = false;
        if (null != tigMaMsgsList && tigMaMsgsList.size() > 0) {
            for (TigMaMsgs tigMaMsgs : tigMaMsgsList) {
                resultFlag = tigMaMsgsDao.insert(tigMaMsgs);
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
    public boolean insert(TigMaMsgs tigMaMsgs) {
        return tigMaMsgsDao.insert(tigMaMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigMaMsgs tigMaMsgs) {
        return tigMaMsgsDao.update(tigMaMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaMsgs> queryTigMaMsgsList(TigMaMsgsQuery queryBean) {
        return tigMaMsgsDao.queryTigMaMsgsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigMaMsgs> queryTigMaMsgsListWithPage(TigMaMsgsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigMaMsgsQuery();
        }

        // 查询总数
        int totalItem = queryTigMaMsgsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigMaMsgsDao.queryTigMaMsgsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigMaMsgsCount(TigMaMsgsQuery queryBean) {
        return tigMaMsgsDao.queryTigMaMsgsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigMaMsgs tigMaMsgs) {
        return tigMaMsgsDao.delete(tigMaMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public TigMaMsgs getTigMaMsgsById(Long id) {
        return tigMaMsgsDao.getTigMaMsgsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigMaMsgs[] tigMaMsgss) {
        boolean resultFlag = false;
        if (null != tigMaMsgss && tigMaMsgss.length > 0) {
            for (int i = 0; i < tigMaMsgss.length; i++) {
                resultFlag = delete(tigMaMsgss[i]);
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
    public boolean exist(TigMaMsgs tigMaMsgs) {
        return tigMaMsgsDao.exist(tigMaMsgs);
    }
}
