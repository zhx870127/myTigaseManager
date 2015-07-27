package com.letv.tigase.manager;

import java.util.List;

import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
import com.letv.common.utils.page.PageUtil;
/**
 * TigMaMsgsManager接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public interface TigMaMsgsManager {

    /**
     * 批量增加对象信息
     * 
     * @param tigMaMsgsList
     * @return
     */
    public boolean insert(List<TigMaMsgs> tigMaMsgsList);

    /**
     * 单个增加对象信息
     * 
     * @param tigMaMsgs
     * @return
     */
    public boolean insert(TigMaMsgs tigMaMsgs);

    /**
     * 更新 对象信息
     * 
     * @param tigMaMsgs
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TigMaMsgs tigMaMsgs);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TigMaMsgs> queryTigMaMsgsList(TigMaMsgsQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TigMaMsgs> queryTigMaMsgsListWithPage(TigMaMsgsQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTigMaMsgsCount(TigMaMsgsQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaMsgs
     *            　
     * @return
     */
    public boolean delete(TigMaMsgs tigMaMsgs);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TigMaMsgs getTigMaMsgsById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param tigMaMsgss
     *            TigMaMsgs集合
     * @return
     */
    public boolean delete(TigMaMsgs[] tigMaMsgss);

    /**
     * 判断是否存在
     * 
     * @param tigMaMsgs
     * @return
     */
    public boolean exist(TigMaMsgs tigMaMsgs);
}
