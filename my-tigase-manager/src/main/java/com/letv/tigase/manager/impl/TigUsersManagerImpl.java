package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.domain.query.TigUsersQuery;
import com.letv.tigase.dao.TigUsersDao;
import com.letv.tigase.manager.TigUsersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigUsersManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigUsersManagerImpl extends BaseManager implements TigUsersManager {
	
    @Autowired
    private TigUsersDao tigUsersDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigUsers> tigUsersList) {
        boolean resultFlag = false;
        if (null != tigUsersList && tigUsersList.size() > 0) {
            for (TigUsers tigUsers : tigUsersList) {
                resultFlag = tigUsersDao.insert(tigUsers);
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
    public boolean insert(TigUsers tigUsers) {
        return tigUsersDao.insert(tigUsers);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigUsers tigUsers) {
        return tigUsersDao.update(tigUsers);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigUsers> queryTigUsersList(TigUsersQuery queryBean) {
        return tigUsersDao.queryTigUsersList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigUsers> queryTigUsersListWithPage(TigUsersQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigUsersQuery();
        }

        // 查询总数
        int totalItem = queryTigUsersCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigUsersDao.queryTigUsersListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigUsersCount(TigUsersQuery queryBean) {
        return tigUsersDao.queryTigUsersCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigUsers tigUsers) {
        return tigUsersDao.delete(tigUsers);
    }

    /**
     * {@inheritDoc}
     */
    public TigUsers getTigUsersById(Long id) {
        return tigUsersDao.getTigUsersById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigUsers[] tigUserss) {
        boolean resultFlag = false;
        if (null != tigUserss && tigUserss.length > 0) {
            for (int i = 0; i < tigUserss.length; i++) {
                resultFlag = delete(tigUserss[i]);
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
    public boolean exist(TigUsers tigUsers) {
        return tigUsersDao.exist(tigUsers);
    }
}
