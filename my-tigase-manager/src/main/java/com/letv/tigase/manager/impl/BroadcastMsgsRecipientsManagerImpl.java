package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
import com.letv.tigase.dao.BroadcastMsgsRecipientsDao;
import com.letv.tigase.manager.BroadcastMsgsRecipientsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BroadcastMsgsRecipientsManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class BroadcastMsgsRecipientsManagerImpl extends BaseManager implements BroadcastMsgsRecipientsManager {
	
    @Autowired
    private BroadcastMsgsRecipientsDao broadcastMsgsRecipientsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<BroadcastMsgsRecipients> broadcastMsgsRecipientsList) {
        boolean resultFlag = false;
        if (null != broadcastMsgsRecipientsList && broadcastMsgsRecipientsList.size() > 0) {
            for (BroadcastMsgsRecipients broadcastMsgsRecipients : broadcastMsgsRecipientsList) {
                resultFlag = broadcastMsgsRecipientsDao.insert(broadcastMsgsRecipients);
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
    public boolean insert(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return broadcastMsgsRecipientsDao.insert(broadcastMsgsRecipients);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return broadcastMsgsRecipientsDao.update(broadcastMsgsRecipients);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsList(BroadcastMsgsRecipientsQuery queryBean) {
        return broadcastMsgsRecipientsDao.queryBroadcastMsgsRecipientsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BroadcastMsgsRecipients> queryBroadcastMsgsRecipientsListWithPage(BroadcastMsgsRecipientsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new BroadcastMsgsRecipientsQuery();
        }

        // 查询总数
        int totalItem = queryBroadcastMsgsRecipientsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return broadcastMsgsRecipientsDao.queryBroadcastMsgsRecipientsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryBroadcastMsgsRecipientsCount(BroadcastMsgsRecipientsQuery queryBean) {
        return broadcastMsgsRecipientsDao.queryBroadcastMsgsRecipientsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return broadcastMsgsRecipientsDao.delete(broadcastMsgsRecipients);
    }

    /**
     * {@inheritDoc}
     */
    public BroadcastMsgsRecipients getBroadcastMsgsRecipientsById(Long id) {
        return broadcastMsgsRecipientsDao.getBroadcastMsgsRecipientsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final BroadcastMsgsRecipients[] broadcastMsgsRecipientss) {
        boolean resultFlag = false;
        if (null != broadcastMsgsRecipientss && broadcastMsgsRecipientss.length > 0) {
            for (int i = 0; i < broadcastMsgsRecipientss.length; i++) {
                resultFlag = delete(broadcastMsgsRecipientss[i]);
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
    public boolean exist(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        return broadcastMsgsRecipientsDao.exist(broadcastMsgsRecipients);
    }
}
