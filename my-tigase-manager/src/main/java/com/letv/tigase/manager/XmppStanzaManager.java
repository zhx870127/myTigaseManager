package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * XmppStanzaManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface XmppStanzaManager {

    /**
     * 批量增加对象信息
     * 
     * @param xmppStanzaList
     * @return
     */
    public boolean insert(List<XmppStanza> xmppStanzaList);

    /**
     * 单个增加对象信息
     * 
     * @param xmppStanza
     * @return
     */
    public boolean insert(XmppStanza xmppStanza);

    /**
     * 更新 对象信息
     * 
     * @param xmppStanza
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(XmppStanza xmppStanza);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<XmppStanza> queryXmppStanzaList(XmppStanzaQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<XmppStanza> queryXmppStanzaListWithPage(XmppStanzaQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryXmppStanzaCount(XmppStanzaQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param xmppStanza
     *            　
     * @return
     */
    public boolean delete(XmppStanza xmppStanza);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public XmppStanza getXmppStanzaById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param xmppStanzas
     *            XmppStanza集合
     * @return
     */
    public boolean delete(XmppStanza[] xmppStanzas);

    /**
     * 判断是否存在
     * 
     * @param xmppStanza
     * @return
     */
    public boolean exist(XmppStanza xmppStanza);
}
