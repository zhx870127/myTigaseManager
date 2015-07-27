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
import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.domain.query.TigPubsubSubscriptionsQuery;
import com.letv.tigase.service.TigPubsubSubscriptionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubSubscriptionsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubSubscriptions")
public class TigPubsubSubscriptionsController extends BaseController {

    @Autowired
    private TigPubsubSubscriptionsService tigPubsubSubscriptionsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubSubscriptions";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubSubscriptionsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubSubscriptionsQuery query) {
        try {
            List<TigPubsubSubscriptions> dataList = tigPubsubSubscriptionsService.queryTigPubsubSubscriptionsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions index has error.", e);
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
     * @param tigPubsubSubscriptions
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubSubscriptions tigPubsubSubscriptions) {
        try {
            tigPubsubSubscriptions.setCreateUser(getLoginUserCnName());
            if (tigPubsubSubscriptionsService.insert(tigPubsubSubscriptions)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubSubscriptions add fail, exist tigPubsubSubscriptions.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubSubscriptions
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubSubscriptions tigPubsubSubscriptions) {
        try {
            TigPubsubSubscriptions tigPubsubSubscriptionsResult = tigPubsubSubscriptionsService.getTigPubsubSubscriptionsById(tigPubsubSubscriptions.getJidId());
            model.addAttribute("tigPubsubSubscriptions", tigPubsubSubscriptionsResult);
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubSubscriptions
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubSubscriptions tigPubsubSubscriptions) {
        try {
            tigPubsubSubscriptions.setUpdateUser(getLoginUserCnName());
            if (tigPubsubSubscriptionsService.update(tigPubsubSubscriptions)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubSubscriptions
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubSubscriptions tigPubsubSubscriptions) {
        try {
            tigPubsubSubscriptions.setUpdateUser(getLoginUserCnName());
            if (tigPubsubSubscriptionsService.delete(tigPubsubSubscriptions)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions delete has error.", e);
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
    public Wrapper<?> query(TigPubsubSubscriptionsQuery query) {
        try {
            List<TigPubsubSubscriptions> list = tigPubsubSubscriptionsService.queryTigPubsubSubscriptionsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubSubscriptions query has error.", e);
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
    public Wrapper<?> detail(TigPubsubSubscriptionsQuery query) {
        if (null == query || null == query.getJidId()) {
            return illegalArgument();
        }

        try {
            TigPubsubSubscriptions tigPubsubSubscriptions = tigPubsubSubscriptionsService.getTigPubsubSubscriptionsById(query.getJidId());
            if (tigPubsubSubscriptions != null) {
                return new Wrapper<TigPubsubSubscriptions>().result(tigPubsubSubscriptions);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubSubscriptions has error.", e);
            return error();
        }
    }
}
