package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.domain.query.TigNodesQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigNodesManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigNodesManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigNodesList
     * @return
     */
    public boolean insert(List<TigNodes> tigNodesList);

    /**
     * 单个增加对象信息
     * 
     * @param tigNodes
     * @return
     */
    public boolean insert(TigNodes tigNodes);

    /**
     * 更新 对象信息
     * 
     * @param tigNodes
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigNodes tigNodes);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigNodes> queryTigNodesList(TigNodesQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigNodes> queryTigNodesListWithPage(TigNodesQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigNodesCount(TigNodesQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigNodes
     *            　
     * @return
     */
    public boolean delete(TigNodes tigNodes);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigNodes getTigNodesById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigNodess
     *            TigNodes集合
     * @return
     */
    public boolean delete(TigNodes[] tigNodess);

    /**
     * 判断是否存在
     * 
     * @param tigNodes
     * @return
     */
    public boolean exist(TigNodes tigNodes);
}
