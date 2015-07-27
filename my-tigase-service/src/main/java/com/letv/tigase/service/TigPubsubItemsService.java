package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * TigPubsubItemsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public interface TigPubsubItemsService {

    /**
     * 批量增加对象信息
     * 
     * @param tigPubsubItemsList
     * @return
     */
    public boolean insert(List<TigPubsubItems> tigPubsubItemsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigPubsubItems
     * @return
     */
    public boolean insert(TigPubsubItems tigPubsubItems);

    /**
     * 更新 对象信息
     * 
     * @param tigPubsubItems
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigPubsubItems tigPubsubItems);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubItems> queryTigPubsubItemsList(TigPubsubItemsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigPubsubItems> queryTigPubsubItemsListWithPage(TigPubsubItemsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubItems
     *            　
     * @return
     */
    public boolean delete(TigPubsubItems tigPubsubItems);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigPubsubItems getTigPubsubItemsById(String id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubItemss
     *            TigPubsubItems集合
     * @return
     */
    public boolean delete(TigPubsubItems[] tigPubsubItemss);
}
