package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.domain.query.TigUsersQuery;
import com.letv.tigase.manager.TigUsersManager;
import com.letv.tigase.service.TigUsersService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigUsersService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigUsersServiceImpl implements TigUsersService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigUsersServiceImpl.class);

    @Autowired
    private TigUsersManager tigUsersManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.batchInsert")
    public boolean insert(List<TigUsers> tigUsersList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigUsersList)) {
                resultFlag = tigUsersManager.insert(tigUsersList);
            } else {
                LOG.warn("TigUsersServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.insert")
    public boolean insert(TigUsers tigUsers) {
        boolean resultFlag = false;
        try {
            if (null != tigUsers) {
                if (tigUsersManager.exist(tigUsers)) {
                    throw new ExistedException();
                }
                resultFlag = tigUsersManager.insert(tigUsers);
            } else {
                LOG.warn("TigUsersServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigUsersServiceImpl#insert failed, tigUsers has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.update")
    public boolean update(TigUsers tigUsers) {
        boolean resultFlag = false;
        try {
            if (null != tigUsers && null != tigUsers.getUid()) {
                resultFlag = tigUsersManager.update(tigUsers);
            } else {
                LOG.warn("TigUsersServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.queryTigUsersList")
    public List<TigUsers> queryTigUsersList(TigUsersQuery queryBean) {
        List<TigUsers> tigUsersList = null;
        try {
            tigUsersList = tigUsersManager.queryTigUsersList(queryBean);
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#queryTigUsersList has error.", e);
        }
        return tigUsersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.queryTigUsersListWithPage")
    public List<TigUsers> queryTigUsersListWithPage(TigUsersQuery queryBean, PageUtil pageUtil) {
        List<TigUsers> tigUsersList = null;
        try {
            tigUsersList = tigUsersManager.queryTigUsersListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#queryTigUsersListWithPage has error.", e);
        }
        return tigUsersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.delete")
    public boolean delete(TigUsers tigUsers) {
        boolean resultFlag = false;
        try {
            if (null != tigUsers && null != tigUsers.getUid()) {
                resultFlag = tigUsersManager.delete(tigUsers);
            } else {
                LOG.warn("TigUsersServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.batchDelete")
    public boolean delete(TigUsers[] tigUserss) {
        boolean resultFlag = false;
        try {
            if (null != tigUserss && tigUserss.length > 0) {
                resultFlag = tigUsersManager.delete(tigUserss);
            } else {
                LOG.warn("TigUsersServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigUsersService.getTigUsersById")
    public TigUsers getTigUsersById(Long id) {
        TigUsers tigUsers = null;
        try {
            if (null != id) {
                tigUsers = tigUsersManager.getTigUsersById(id);
            } else {
                LOG.warn("TigUsersServiceImpl#getTigUsersById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigUsersServiceImpl#getTigUsersById has error.", e);
        }
        return tigUsers;
    }
}

