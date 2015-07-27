package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.domain.query.TigMaTagsQuery;
/**
 * TigMaTagsDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface TigMaTagsDao {
    
    /**
     * 新增对象
     * 
     * @param tigMaTags 
     * @return
     */
    public boolean insert(TigMaTags tigMaTags);

    /**
     * 更新对象
     * 
     * @param tigMaTags
     * @return
     */
    public boolean update(TigMaTags tigMaTags);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaTags> queryTigMaTagsList(TigMaTagsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTigMaTagsCount(TigMaTagsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaTags> queryTigMaTagsListWithPage(TigMaTagsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tigMaTags
     * @return
     */
    public boolean delete(TigMaTags tigMaTags);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TigMaTags getTigMaTagsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tigMaTags
     * @return
     */
    public boolean exist(TigMaTags tigMaTags);

}
