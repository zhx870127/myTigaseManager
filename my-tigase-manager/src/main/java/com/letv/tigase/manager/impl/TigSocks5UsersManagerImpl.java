package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;
import com.letv.tigase.dao.TigSocks5UsersDao;
import com.letv.tigase.manager.TigSocks5UsersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TigSocks5UsersManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class TigSocks5UsersManagerImpl extends BaseManager implements TigSocks5UsersManager {
	
    @Autowired
    private TigSocks5UsersDao tigSocks5UsersDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TigSocks5Users> tigSocks5UsersList) {
        boolean resultFlag = false;
        if (null != tigSocks5UsersList && tigSocks5UsersList.size() > 0) {
            for (TigSocks5Users tigSocks5Users : tigSocks5UsersList) {
                resultFlag = tigSocks5UsersDao.insert(tigSocks5Users);
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
    public boolean insert(TigSocks5Users tigSocks5Users) {
        return tigSocks5UsersDao.insert(tigSocks5Users);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TigSocks5Users tigSocks5Users) {
        return tigSocks5UsersDao.update(tigSocks5Users);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Users> queryTigSocks5UsersList(TigSocks5UsersQuery queryBean) {
        return tigSocks5UsersDao.queryTigSocks5UsersList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TigSocks5Users> queryTigSocks5UsersListWithPage(TigSocks5UsersQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TigSocks5UsersQuery();
        }

        // 查询总数
        int totalItem = queryTigSocks5UsersCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tigSocks5UsersDao.queryTigSocks5UsersListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTigSocks5UsersCount(TigSocks5UsersQuery queryBean) {
        return tigSocks5UsersDao.queryTigSocks5UsersCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TigSocks5Users tigSocks5Users) {
        return tigSocks5UsersDao.delete(tigSocks5Users);
    }

    /**
     * {@inheritDoc}
     */
    public TigSocks5Users getTigSocks5UsersById(Long id) {
        return tigSocks5UsersDao.getTigSocks5UsersById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TigSocks5Users[] tigSocks5Userss) {
        boolean resultFlag = false;
        if (null != tigSocks5Userss && tigSocks5Userss.length > 0) {
            for (int i = 0; i < tigSocks5Userss.length; i++) {
                resultFlag = delete(tigSocks5Userss[i]);
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
    public boolean exist(TigSocks5Users tigSocks5Users) {
        return tigSocks5UsersDao.exist(tigSocks5Users);
    }
}
