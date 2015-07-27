package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.UserJid;
import com.letv.tigase.domain.query.UserJidQuery;
import com.letv.tigase.manager.UserJidManager;
import com.letv.tigase.service.UserJidService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserJidService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class UserJidServiceImpl implements UserJidService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserJidServiceImpl.class);

    @Autowired
    private UserJidManager userJidManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.batchInsert")
    public boolean insert(List<UserJid> userJidList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userJidList)) {
                resultFlag = userJidManager.insert(userJidList);
            } else {
                LOG.warn("UserJidServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.insert")
    public boolean insert(UserJid userJid) {
        boolean resultFlag = false;
        try {
            if (null != userJid) {
                if (userJidManager.exist(userJid)) {
                    throw new ExistedException();
                }
                resultFlag = userJidManager.insert(userJid);
            } else {
                LOG.warn("UserJidServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserJidServiceImpl#insert failed, userJid has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.update")
    public boolean update(UserJid userJid) {
        boolean resultFlag = false;
        try {
            if (null != userJid && null != userJid.getJidId()) {
                resultFlag = userJidManager.update(userJid);
            } else {
                LOG.warn("UserJidServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.queryUserJidList")
    public List<UserJid> queryUserJidList(UserJidQuery queryBean) {
        List<UserJid> userJidList = null;
        try {
            userJidList = userJidManager.queryUserJidList(queryBean);
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#queryUserJidList has error.", e);
        }
        return userJidList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.queryUserJidListWithPage")
    public List<UserJid> queryUserJidListWithPage(UserJidQuery queryBean, PageUtil pageUtil) {
        List<UserJid> userJidList = null;
        try {
            userJidList = userJidManager.queryUserJidListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#queryUserJidListWithPage has error.", e);
        }
        return userJidList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.delete")
    public boolean delete(UserJid userJid) {
        boolean resultFlag = false;
        try {
            if (null != userJid && null != userJid.getJidId()) {
                resultFlag = userJidManager.delete(userJid);
            } else {
                LOG.warn("UserJidServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.batchDelete")
    public boolean delete(UserJid[] userJids) {
        boolean resultFlag = false;
        try {
            if (null != userJids && userJids.length > 0) {
                resultFlag = userJidManager.delete(userJids);
            } else {
                LOG.warn("UserJidServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserJidService.getUserJidById")
    public UserJid getUserJidById(Long id) {
        UserJid userJid = null;
        try {
            if (null != id) {
                userJid = userJidManager.getUserJidById(id);
            } else {
                LOG.warn("UserJidServiceImpl#getUserJidById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserJidServiceImpl#getUserJidById has error.", e);
        }
        return userJid;
    }
}

