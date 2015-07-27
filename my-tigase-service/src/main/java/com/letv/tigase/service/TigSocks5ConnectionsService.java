package com.letv.tigase.service;

import java.util.List;

import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
import com.letv.common.utils.page.PageUtil;

/**
 * TigSocks5ConnectionsService接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public interface TigSocks5ConnectionsService {

    /**
     * 批量增加对象信息
     * 
     * @param tigSocks5ConnectionsList
     * @return
     */
    public boolean insert(List<TigSocks5Connections> tigSocks5ConnectionsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigSocks5Connections
     * @return
     */
    public boolean insert(TigSocks5Connections tigSocks5Connections);

    /**
     * 更新 对象信息
     * 
     * @param tigSocks5Connections
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigSocks5Connections tigSocks5Connections);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsList(TigSocks5ConnectionsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigSocks5Connections> queryTigSocks5ConnectionsListWithPage(TigSocks5ConnectionsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigSocks5Connections
     *            　
     * @return
     */
    public boolean delete(TigSocks5Connections tigSocks5Connections);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigSocks5Connections getTigSocks5ConnectionsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigSocks5Connectionss
     *            TigSocks5Connections集合
     * @return
     */
    public boolean delete(TigSocks5Connections[] tigSocks5Connectionss);
}
