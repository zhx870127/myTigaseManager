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
import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.domain.query.MsgHistoryQuery;
import com.letv.tigase.service.MsgHistoryService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * MsgHistoryController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("msgHistory")
public class MsgHistoryController extends BaseController {

    @Autowired
    private MsgHistoryService msgHistoryService;

    /** 视图前缀 */
    private static final String viewPrefix ="msgHistory";
    
    private static final Log LOG = LogFactory.getLog(MsgHistoryController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, MsgHistoryQuery query) {
        try {
            List<MsgHistory> dataList = msgHistoryService.queryMsgHistoryListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("msgHistory index has error.", e);
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
     * @param msgHistory
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(MsgHistory msgHistory) {
        try {
            msgHistory.setCreateUser(getLoginUserCnName());
            if (msgHistoryService.insert(msgHistory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("msgHistory add fail, exist msgHistory.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("msgHistory add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param msgHistory
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, MsgHistory msgHistory) {
        try {
            MsgHistory msgHistoryResult = msgHistoryService.getMsgHistoryById(msgHistory.getMsgId());
            model.addAttribute("msgHistory", msgHistoryResult);
        } catch (Exception e) {
            LOG.error("msgHistory updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param msgHistory
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, MsgHistory msgHistory) {
        try {
            msgHistory.setUpdateUser(getLoginUserCnName());
            if (msgHistoryService.update(msgHistory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("msgHistory update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param msgHistory
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(MsgHistory msgHistory) {
        try {
            msgHistory.setUpdateUser(getLoginUserCnName());
            if (msgHistoryService.delete(msgHistory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("msgHistory delete has error.", e);
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
    public Wrapper<?> query(MsgHistoryQuery query) {
        try {
            List<MsgHistory> list = msgHistoryService.queryMsgHistoryList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("msgHistory query has error.", e);
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
    public Wrapper<?> detail(MsgHistoryQuery query) {
        if (null == query || null == query.getMsgId()) {
            return illegalArgument();
        }

        try {
            MsgHistory msgHistory = msgHistoryService.getMsgHistoryById(query.getMsgId());
            if (msgHistory != null) {
                return new Wrapper<MsgHistory>().result(msgHistory);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail msgHistory has error.", e);
            return error();
        }
    }
}
