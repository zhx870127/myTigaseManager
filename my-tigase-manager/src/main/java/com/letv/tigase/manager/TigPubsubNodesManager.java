package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigPubsubNodesManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigPubsubNodesManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigPubsubNodesList
     * @return
     */
    public boolean insert(List<TigPubsubNodes> tigPubsubNodesList);

    /**
     * 单个增加对象信息
     * 
     * @param tigPubsubNodes
     * @return
     */
    public boolean insert(TigPubsubNodes tigPubsubNodes);

    /**
     * 更新 对象信息
     * 
     * @param tigPubsubNodes
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigPubsubNodes tigPubsubNodes);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigPubsubNodes> queryTigPubsubNodesList(TigPubsubNodesQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigPubsubNodes> queryTigPubsubNodesListWithPage(TigPubsubNodesQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigPubsubNodesCount(TigPubsubNodesQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubNodes
     *            　
     * @return
     */
    public boolean delete(TigPubsubNodes tigPubsubNodes);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigPubsubNodes getTigPubsubNodesById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigPubsubNodess
     *            TigPubsubNodes集合
     * @return
     */
    public boolean delete(TigPubsubNodes[] tigPubsubNodess);

    /**
     * 判断是否存在
     * 
     * @param tigPubsubNodes
     * @return
     */
    public boolean exist(TigPubsubNodes tigPubsubNodes);
}
