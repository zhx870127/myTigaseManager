package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.domain.query.ShortNewsQuery;
/**
 * ShortNewsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface ShortNewsDao {
    
    /**
     * 新增对象
     * 
     * @param shortNews 
     * @return
     */
    public boolean insert(ShortNews shortNews);

    /**
     * 更新对象
     * 
     * @param shortNews
     * @return
     */
    public boolean update(ShortNews shortNews);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShortNews> queryShortNewsList(ShortNewsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryShortNewsCount(ShortNewsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShortNews> queryShortNewsListWithPage(ShortNewsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param shortNews
     * @return
     */
    public boolean delete(ShortNews shortNews);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ShortNews getShortNewsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param shortNews
     * @return
     */
    public boolean exist(ShortNews shortNews);

}
