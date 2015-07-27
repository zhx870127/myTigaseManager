package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.UserJid;
import com.letv.tigase.domain.query.UserJidQuery;
import com.letv.tigase.dao.UserJidDao;
import com.letv.tigase.manager.UserJidManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserJidManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class UserJidManagerImpl extends BaseManager implements UserJidManager {
	
    @Autowired
    private UserJidDao userJidDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserJid> userJidList) {
        boolean resultFlag = false;
        if (null != userJidList && userJidList.size() > 0) {
            for (UserJid userJid : userJidList) {
                resultFlag = userJidDao.insert(userJid);
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
    public boolean insert(UserJid userJid) {
        return userJidDao.insert(userJid);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserJid userJid) {
        return userJidDao.update(userJid);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserJid> queryUserJidList(UserJidQuery queryBean) {
        return userJidDao.queryUserJidList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserJid> queryUserJidListWithPage(UserJidQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserJidQuery();
        }

        // 查询总数
        int totalItem = queryUserJidCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userJidDao.queryUserJidListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserJidCount(UserJidQuery queryBean) {
        return userJidDao.queryUserJidCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserJid userJid) {
        return userJidDao.delete(userJid);
    }

    /**
     * {@inheritDoc}
     */
    public UserJid getUserJidById(Long id) {
        return userJidDao.getUserJidById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserJid[] userJids) {
        boolean resultFlag = false;
        if (null != userJids && userJids.length > 0) {
            for (int i = 0; i < userJids.length; i++) {
                resultFlag = delete(userJids[i]);
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
    public boolean exist(UserJid userJid) {
        return userJidDao.exist(userJid);
    }
}
