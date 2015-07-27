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
import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.domain.query.BroadcastMsgsQuery;
import com.letv.tigase.service.BroadcastMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * BroadcastMsgsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("broadcastMsgs")
public class BroadcastMsgsController extends BaseController {

    @Autowired
    private BroadcastMsgsService broadcastMsgsService;

    /** 视图前缀 */
    private static final String viewPrefix ="broadcastMsgs";
    
    private static final Log LOG = LogFactory.getLog(BroadcastMsgsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, BroadcastMsgsQuery query) {
        try {
            List<BroadcastMsgs> dataList = broadcastMsgsService.queryBroadcastMsgsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("broadcastMsgs index has error.", e);
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
     * @param broadcastMsgs
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(BroadcastMsgs broadcastMsgs) {
        try {
            broadcastMsgs.setCreateUser(getLoginUserCnName());
            if (broadcastMsgsService.insert(broadcastMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("broadcastMsgs add fail, exist broadcastMsgs.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("broadcastMsgs add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param broadcastMsgs
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, BroadcastMsgs broadcastMsgs) {
        try {
            BroadcastMsgs broadcastMsgsResult = broadcastMsgsService.getBroadcastMsgsById(broadcastMsgs.getId());
            model.addAttribute("broadcastMsgs", broadcastMsgsResult);
        } catch (Exception e) {
            LOG.error("broadcastMsgs updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param broadcastMsgs
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, BroadcastMsgs broadcastMsgs) {
        try {
            broadcastMsgs.setUpdateUser(getLoginUserCnName());
            if (broadcastMsgsService.update(broadcastMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgs update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param broadcastMsgs
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(BroadcastMsgs broadcastMsgs) {
        try {
            broadcastMsgs.setUpdateUser(getLoginUserCnName());
            if (broadcastMsgsService.delete(broadcastMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgs delete has error.", e);
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
    public Wrapper<?> query(BroadcastMsgsQuery query) {
        try {
            List<BroadcastMsgs> list = broadcastMsgsService.queryBroadcastMsgsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("broadcastMsgs query has error.", e);
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
    public Wrapper<?> detail(BroadcastMsgsQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            BroadcastMsgs broadcastMsgs = broadcastMsgsService.getBroadcastMsgsById(query.getId());
            if (broadcastMsgs != null) {
                return new Wrapper<BroadcastMsgs>().result(broadcastMsgs);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail broadcastMsgs has error.", e);
            return error();
        }
    }
}
