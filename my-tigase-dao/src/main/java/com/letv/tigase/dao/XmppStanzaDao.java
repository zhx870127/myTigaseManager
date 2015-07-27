package com.letv.tigase.dao;

import java.util.List;

import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;
/**
 * XmppStanzaDao接口<br/>
 * 对''表进行基本的操作
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:57
 * 
 */
public interface XmppStanzaDao {
    
    /**
     * 新增对象
     * 
     * @param xmppStanza 
     * @return
     */
    public boolean insert(XmppStanza xmppStanza);

    /**
     * 更新对象
     * 
     * @param xmppStanza
     * @return
     */
    public boolean update(XmppStanza xmppStanza);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<XmppStanza> queryXmppStanzaList(XmppStanzaQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryXmppStanzaCount(XmppStanzaQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<XmppStanza> queryXmppStanzaListWithPage(XmppStanzaQuery queryBean);

    /**
     * 删除记录
     * 
     * @param xmppStanza
     * @return
     */
    public boolean delete(XmppStanza xmppStanza);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public XmppStanza getXmppStanzaById(Long id);

    /**
     * 判断是否存在
     * 
     * @param xmppStanza
     * @return
     */
    public boolean exist(XmppStanza xmppStanza);

}
