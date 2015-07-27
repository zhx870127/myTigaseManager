package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.domain.query.TigMaTagsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * TigMaTagsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public interface TigMaTagsService {

    /**
     * 批量增加对象信息
     * 
     * @param tigMaTagsList
     * @return
     */
    public boolean insert(List<TigMaTags> tigMaTagsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigMaTags
     * @return
     */
    public boolean insert(TigMaTags tigMaTags);

    /**
     * 更新 对象信息
     * 
     * @param tigMaTags
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigMaTags tigMaTags);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaTags> queryTigMaTagsList(TigMaTagsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigMaTags> queryTigMaTagsListWithPage(TigMaTagsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaTags
     *            　
     * @return
     */
    public boolean delete(TigMaTags tigMaTags);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigMaTags getTigMaTagsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaTagss
     *            TigMaTags集合
     * @return
     */
    public boolean delete(TigMaTags[] tigMaTagss);
}
