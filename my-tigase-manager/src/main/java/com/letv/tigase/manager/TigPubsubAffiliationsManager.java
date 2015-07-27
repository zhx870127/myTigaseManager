package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigPubsubAffiliationsManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigPubsubAffiliationsManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigPubsubAffiliationsList
     * @return
     */
    public boolean insert(List<TigPubsubAffiliations> tigPubsubAffiliationsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    public boolean insert(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 更新 对象信息
     * 
     * @param tigPubsubAffiliations
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsList(TigPubsubAffiliationsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigPubsubAffiliations> queryTigPubsubAffiliationsListWithPage(TigPubsubAffiliationsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigPubsubAffiliationsCount(TigPubsubAffiliationsQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubAffiliations
     *            　
     * @return
     */
    public boolean delete(TigPubsubAffiliations tigPubsubAffiliations);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigPubsubAffiliations getTigPubsubAffiliationsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubAffiliationss
     *            TigPubsubAffiliations集合
     * @return
     */
    public boolean delete(TigPubsubAffiliations[] tigPubsubAffiliationss);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    public boolean exist(TigPubsubAffiliations tigPubsubAffiliations);
}
