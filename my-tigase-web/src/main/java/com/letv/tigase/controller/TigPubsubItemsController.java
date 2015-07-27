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
import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.domain.query.TigPubsubItemsQuery;
import com.letv.tigase.service.TigPubsubItemsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubItemsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubItems")
public class TigPubsubItemsController extends BaseController {

    @Autowired
    private TigPubsubItemsService tigPubsubItemsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubItems";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubItemsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubItemsQuery query) {
        try {
            List<TigPubsubItems> dataList = tigPubsubItemsService.queryTigPubsubItemsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubItems index has error.", e);
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
     * @param tigPubsubItems
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubItems tigPubsubItems) {
        try {
            tigPubsubItems.setCreateUser(getLoginUserCnName());
            if (tigPubsubItemsService.insert(tigPubsubItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubItems add fail, exist tigPubsubItems.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubItems add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubItems
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubItems tigPubsubItems) {
        try {
            TigPubsubItems tigPubsubItemsResult = tigPubsubItemsService.getTigPubsubItemsById(tigPubsubItems.getIdSha1());
            model.addAttribute("tigPubsubItems", tigPubsubItemsResult);
        } catch (Exception e) {
            LOG.error("tigPubsubItems updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubItems
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubItems tigPubsubItems) {
        try {
            tigPubsubItems.setUpdateUser(getLoginUserCnName());
            if (tigPubsubItemsService.update(tigPubsubItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubItems update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubItems
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubItems tigPubsubItems) {
        try {
            tigPubsubItems.setUpdateUser(getLoginUserCnName());
            if (tigPubsubItemsService.delete(tigPubsubItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubItems delete has error.", e);
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
    public Wrapper<?> query(TigPubsubItemsQuery query) {
        try {
            List<TigPubsubItems> list = tigPubsubItemsService.queryTigPubsubItemsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubItems query has error.", e);
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
    public Wrapper<?> detail(TigPubsubItemsQuery query) {
        if (null == query || null == query.getIdSha1()) {
            return illegalArgument();
        }

        try {
            TigPubsubItems tigPubsubItems = tigPubsubItemsService.getTigPubsubItemsById(query.getIdSha1());
            if (tigPubsubItems != null) {
                return new Wrapper<TigPubsubItems>().result(tigPubsubItems);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubItems has error.", e);
            return error();
        }
    }
}
