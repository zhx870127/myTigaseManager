package com.letv.tigase.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;
import com.letv.tigase.manager.TigSocks5UsersManager;
import com.letv.tigase.service.TigSocks5UsersService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TigSocks5UsersService接口的实现类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
@Service
public class TigSocks5UsersServiceImpl implements TigSocks5UsersService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TigSocks5UsersServiceImpl.class);

    @Autowired
    private TigSocks5UsersManager tigSocks5UsersManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.batchInsert")
    public boolean insert(List<TigSocks5Users> tigSocks5UsersList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tigSocks5UsersList)) {
                resultFlag = tigSocks5UsersManager.insert(tigSocks5UsersList);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.insert")
    public boolean insert(TigSocks5Users tigSocks5Users) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Users) {
                if (tigSocks5UsersManager.exist(tigSocks5Users)) {
                    throw new ExistedException();
                }
                resultFlag = tigSocks5UsersManager.insert(tigSocks5Users);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TigSocks5UsersServiceImpl#insert failed, tigSocks5Users has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.update")
    public boolean update(TigSocks5Users tigSocks5Users) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Users && null != tigSocks5Users.getUid()) {
                resultFlag = tigSocks5UsersManager.update(tigSocks5Users);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.queryTigSocks5UsersList")
    public List<TigSocks5Users> queryTigSocks5UsersList(TigSocks5UsersQuery queryBean) {
        List<TigSocks5Users> tigSocks5UsersList = null;
        try {
            tigSocks5UsersList = tigSocks5UsersManager.queryTigSocks5UsersList(queryBean);
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#queryTigSocks5UsersList has error.", e);
        }
        return tigSocks5UsersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.queryTigSocks5UsersListWithPage")
    public List<TigSocks5Users> queryTigSocks5UsersListWithPage(TigSocks5UsersQuery queryBean, PageUtil pageUtil) {
        List<TigSocks5Users> tigSocks5UsersList = null;
        try {
            tigSocks5UsersList = tigSocks5UsersManager.queryTigSocks5UsersListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#queryTigSocks5UsersListWithPage has error.", e);
        }
        return tigSocks5UsersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.delete")
    public boolean delete(TigSocks5Users tigSocks5Users) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Users && null != tigSocks5Users.getUid()) {
                resultFlag = tigSocks5UsersManager.delete(tigSocks5Users);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.batchDelete")
    public boolean delete(TigSocks5Users[] tigSocks5Userss) {
        boolean resultFlag = false;
        try {
            if (null != tigSocks5Userss && tigSocks5Userss.length > 0) {
                resultFlag = tigSocks5UsersManager.delete(tigSocks5Userss);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TigSocks5UsersService.getTigSocks5UsersById")
    public TigSocks5Users getTigSocks5UsersById(Long id) {
        TigSocks5Users tigSocks5Users = null;
        try {
            if (null != id) {
                tigSocks5Users = tigSocks5UsersManager.getTigSocks5UsersById(id);
            } else {
                LOG.warn("TigSocks5UsersServiceImpl#getTigSocks5UsersById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TigSocks5UsersServiceImpl#getTigSocks5UsersById has error.", e);
        }
        return tigSocks5Users;
    }
}

