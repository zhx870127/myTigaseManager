package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * TigPubsubServiceJidsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public interface TigPubsubServiceJidsService {

    /**
     * 批量增加对象信息
     * 
     * @param tigPubsubServiceJidsList
     * @return
     */
    public boolean insert(List<TigPubsubServiceJids> tigPubsubServiceJidsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigPubsubServiceJids
     * @return
     */
    public boolean insert(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 更新 对象信息
     * 
     * @param tigPubsubServiceJids
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsList(TigPubsubServiceJidsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigPubsubServiceJids> queryTigPubsubServiceJidsListWithPage(TigPubsubServiceJidsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubServiceJids
     *            　
     * @return
     */
    public boolean delete(TigPubsubServiceJids tigPubsubServiceJids);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigPubsubServiceJids getTigPubsubServiceJidsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubServiceJidss
     *            TigPubsubServiceJids集合
     * @return
     */
    public boolean delete(TigPubsubServiceJids[] tigPubsubServiceJidss);
}
