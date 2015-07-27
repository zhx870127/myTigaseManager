package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.domain.query.ShortNewsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * ShortNewsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface ShortNewsService {

    /**
     * 批量增加对象信息
     * 
     * @param shortNewsList
     * @return
     */
    public boolean insert(List<ShortNews> shortNewsList);

    /**
     * 单个增加对象信息
     * 
     * @param shortNews
     * @return
     */
    public boolean insert(ShortNews shortNews);

    /**
     * 更新 对象信息
     * 
     * @param shortNews
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ShortNews shortNews);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShortNews> queryShortNewsList(ShortNewsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ShortNews> queryShortNewsListWithPage(ShortNewsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param shortNews
     *            　
     * @return
     */
    public boolean delete(ShortNews shortNews);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ShortNews getShortNewsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param shortNewss
     *            ShortNews集合
     * @return
     */
    public boolean delete(ShortNews[] shortNewss);
}
