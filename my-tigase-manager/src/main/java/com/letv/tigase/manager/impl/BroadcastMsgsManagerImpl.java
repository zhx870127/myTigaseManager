package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
import com.letv.tigase.dao.BroadcastMsgsDao;
import com.letv.tigase.manager.BroadcastMsgsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BroadcastMsgsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class BroadcastMsgsManagerImpl extends BaseManager implements BroadcastMsgsManager {
	
    @Autowired
    private BroadcastMsgsDao broadcastMsgsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<BroadcastMsgs> broadcastMsgsList) {
        boolean resultFlag = false;
        if (null != broadcastMsgsList && broadcastMsgsList.size() > 0) {
            for (BroadcastMsgs broadcastMsgs : broadcastMsgsList) {
                resultFlag = broadcastMsgsDao.insert(broadcastMsgs);
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
    public boolean insert(BroadcastMsgs broadcastMsgs) {
        return broadcastMsgsDao.insert(broadcastMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final BroadcastMsgs broadcastMsgs) {
        return broadcastMsgsDao.update(broadcastMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgs> queryBroadcastMsgsList(BroadcastMsgsQuery queryBean) {
        return broadcastMsgsDao.queryBroadcastMsgsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgs> queryBroadcastMsgsListWithPage(BroadcastMsgsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new BroadcastMsgsQuery();
        }

        // 查询总数
        int totalItem = queryBroadcastMsgsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return broadcastMsgsDao.queryBroadcastMsgsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryBroadcastMsgsCount(BroadcastMsgsQuery queryBean) {
        return broadcastMsgsDao.queryBroadcastMsgsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BroadcastMsgs broadcastMsgs) {
        return broadcastMsgsDao.delete(broadcastMsgs);
    }

    /**
     * {@inheritDoc}
     */
    public BroadcastMsgs getBroadcastMsgsById(String id) {
        return broadcastMsgsDao.getBroadcastMsgsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final BroadcastMsgs[] broadcastMsgss) {
        boolean resultFlag = false;
        if (null != broadcastMsgss && broadcastMsgss.length > 0) {
            for (int i = 0; i < broadcastMsgss.length; i++) {
                resultFlag = delete(broadcastMsgss[i]);
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
    public boolean exist(BroadcastMsgs broadcastMsgs) {
        return broadcastMsgsDao.exist(broadcastMsgs);
    }
}
