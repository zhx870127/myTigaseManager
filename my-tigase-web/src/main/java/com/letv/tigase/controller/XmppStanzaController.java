package com.letv.tigase.controller;
   

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letv.tigase.controller.base.BaseController;
import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.domain.query.XmppStanzaQuery;
import com.letv.tigase.service.XmppStanzaService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * XmppStanzaController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("xmppStanza")
public class XmppStanzaController extends BaseController {

    @Autowired
    private XmppStanzaService xmppStanzaService;

    /** 视图前缀 */
    private static final String viewPrefix ="xmppStanza";
    
    private static final Log LOG = LogFactory.getLog(XmppStanzaController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, XmppStanzaQuery query) {
        try {
            List<XmppStanza> dataList = xmppStanzaService.queryXmppStanzaListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("xmppStanza index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * ----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * ----添加
     * 
     * @param xmppStanza
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(XmppStanza xmppStanza) {
        try {
            xmppStanza.setCreateUser(getLoginUserCnName());
            if (xmppStanzaService.insert(xmppStanza)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("xmppStanza add fail, exist xmppStanza.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("xmppStanza add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param xmppStanza
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, XmppStanza xmppStanza) {
        try {
            XmppStanza xmppStanzaResult = xmppStanzaService.getXmppStanzaById(xmppStanza.getId());
            model.addAttribute("xmppStanza", xmppStanzaResult);
        } catch (Exception e) {
            LOG.error("xmppStanza updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param xmppStanza
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, XmppStanza xmppStanza) {
        try {
            xmppStanza.setUpdateUser(getLoginUserCnName());
            if (xmppStanzaService.update(xmppStanza)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("xmppStanza update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param xmppStanza
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(XmppStanza xmppStanza) {
        try {
            xmppStanza.setUpdateUser(getLoginUserCnName());
            if (xmppStanzaService.delete(xmppStanza)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("xmppStanza delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(XmppStanzaQuery query) {
        try {
            List<XmppStanza> list = xmppStanzaService.queryXmppStanzaList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("xmppStanza query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(XmppStanzaQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            XmppStanza xmppStanza = xmppStanzaService.getXmppStanzaById(query.getId());
            if (xmppStanza != null) {
                return new Wrapper<XmppStanza>().result(xmppStanza);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail xmppStanza has error.", e);
            return error();
        }
    }
}
