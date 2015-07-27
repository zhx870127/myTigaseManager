package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigMaJidsManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigMaJidsManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigMaJidsList
     * @return
     */
    public boolean insert(List<TigMaJids> tigMaJidsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigMaJids
     * @return
     */
    public boolean insert(TigMaJids tigMaJids);

    /**
     * 更新 对象信息
     * 
     * @param tigMaJids
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigMaJids tigMaJids);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaJids> queryTigMaJidsList(TigMaJidsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigMaJids> queryTigMaJidsListWithPage(TigMaJidsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigMaJidsCount(TigMaJidsQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaJids
     *            　
     * @return
     */
    public boolean delete(TigMaJids tigMaJids);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigMaJids getTigMaJidsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaJidss
     *            TigMaJids集合
     * @return
     */
    public boolean delete(TigMaJids[] tigMaJidss);

    /**
     * 判断是否存在
     * 
     * @param tigMaJids
     * @return
     */
    public boolean exist(TigMaJids tigMaJids);
}
