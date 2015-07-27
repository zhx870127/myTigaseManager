package com.letv.tigase.manager.impl;

import java.util.List;

import com.letv.common.manager.BaseManager;
import com.letv.common.utils.page.PageUtil;
import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
import com.letv.tigase.dao.MsgHistoryDao;
import com.letv.tigase.manager.MsgHistoryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MsgHistoryManager接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
@Component
public class MsgHistoryManagerImpl extends BaseManager implements MsgHistoryManager {
	
    @Autowired
    private MsgHistoryDao msgHistoryDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<MsgHistory> msgHistoryList) {
        boolean resultFlag = false;
        if (null != msgHistoryList && msgHistoryList.size() > 0) {
            for (MsgHistory msgHistory : msgHistoryList) {
                resultFlag = msgHistoryDao.insert(msgHistory);
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
    public boolean insert(MsgHistory msgHistory) {
        return msgHistoryDao.insert(msgHistory);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final MsgHistory msgHistory) {
        return msgHistoryDao.update(msgHistory);
    }

    /**
     * {@inheritDoc}
     */
    public List<MsgHistory> queryMsgHistoryList(MsgHistoryQuery queryBean) {
        return msgHistoryDao.queryMsgHistoryList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<MsgHistory> queryMsgHistoryListWithPage(MsgHistoryQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new MsgHistoryQuery();
        }

        // 查询总数
        int totalItem = queryMsgHistoryCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return msgHistoryDao.queryMsgHistoryListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryMsgHistoryCount(MsgHistoryQuery queryBean) {
        return msgHistoryDao.queryMsgHistoryCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(MsgHistory msgHistory) {
        return msgHistoryDao.delete(msgHistory);
    }

    /**
     * {@inheritDoc}
     */
    public MsgHistory getMsgHistoryById(Long id) {
        return msgHistoryDao.getMsgHistoryById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final MsgHistory[] msgHistorys) {
        boolean resultFlag = false;
        if (null != msgHistorys && msgHistorys.length > 0) {
            for (int i = 0; i < msgHistorys.length; i++) {
                resultFlag = delete(msgHistorys[i]);
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
    public boolean exist(MsgHistory msgHistory) {
        return msgHistoryDao.exist(msgHistory);
    }
}
