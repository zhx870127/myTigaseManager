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
import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.domain.query.BroadcastMsgsRecipientsQuery;
import com.letv.tigase.service.BroadcastMsgsRecipientsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * BroadcastMsgsRecipientsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("broadcastMsgsRecipients")
public class BroadcastMsgsRecipientsController extends BaseController {

    @Autowired
    private BroadcastMsgsRecipientsService broadcastMsgsRecipientsService;

    /** 视图前缀 */
    private static final String viewPrefix ="broadcastMsgsRecipients";
    
    private static final Log LOG = LogFactory.getLog(BroadcastMsgsRecipientsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, BroadcastMsgsRecipientsQuery query) {
        try {
            List<BroadcastMsgsRecipients> dataList = broadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients index has error.", e);
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
     * @param broadcastMsgsRecipients
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        try {
            broadcastMsgsRecipients.setCreateUser(getLoginUserCnName());
            if (broadcastMsgsRecipientsService.insert(broadcastMsgsRecipients)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("broadcastMsgsRecipients add fail, exist broadcastMsgsRecipients.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param broadcastMsgsRecipients
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, BroadcastMsgsRecipients broadcastMsgsRecipients) {
        try {
            BroadcastMsgsRecipients broadcastMsgsRecipientsResult = broadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById(broadcastMsgsRecipients.getJidId());
            model.addAttribute("broadcastMsgsRecipients", broadcastMsgsRecipientsResult);
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param broadcastMsgsRecipients
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, BroadcastMsgsRecipients broadcastMsgsRecipients) {
        try {
            broadcastMsgsRecipients.setUpdateUser(getLoginUserCnName());
            if (broadcastMsgsRecipientsService.update(broadcastMsgsRecipients)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param broadcastMsgsRecipients
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        try {
            broadcastMsgsRecipients.setUpdateUser(getLoginUserCnName());
            if (broadcastMsgsRecipientsService.delete(broadcastMsgsRecipients)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients delete has error.", e);
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
    public Wrapper<?> query(BroadcastMsgsRecipientsQuery query) {
        try {
            List<BroadcastMsgsRecipients> list = broadcastMsgsRecipientsService.queryBroadcastMsgsRecipientsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgsRecipients query has error.", e);
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
    public Wrapper<?> detail(BroadcastMsgsRecipientsQuery query) {
        if (null == query || null == query.getJidId()) {
            return illegalArgument();
        }

        try {
            BroadcastMsgsRecipients broadcastMsgsRecipients = broadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById(query.getJidId());
            if (broadcastMsgsRecipients != null) {
                return new Wrapper<BroadcastMsgsRecipients>().result(broadcastMsgsRecipients);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail broadcastMsgsRecipients has error.", e);
            return error();
        }
    }
}
