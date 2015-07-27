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
import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.domain.query.TigPubsubServiceJidsQuery;
import com.letv.tigase.service.TigPubsubServiceJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubServiceJidsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubServiceJids")
public class TigPubsubServiceJidsController extends BaseController {

    @Autowired
    private TigPubsubServiceJidsService tigPubsubServiceJidsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubServiceJids";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubServiceJidsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubServiceJidsQuery query) {
        try {
            List<TigPubsubServiceJids> dataList = tigPubsubServiceJidsService.queryTigPubsubServiceJidsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids index has error.", e);
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
     * @param tigPubsubServiceJids
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubServiceJids tigPubsubServiceJids) {
        try {
            tigPubsubServiceJids.setCreateUser(getLoginUserCnName());
            if (tigPubsubServiceJidsService.insert(tigPubsubServiceJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubServiceJids add fail, exist tigPubsubServiceJids.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubServiceJids
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubServiceJids tigPubsubServiceJids) {
        try {
            TigPubsubServiceJids tigPubsubServiceJidsResult = tigPubsubServiceJidsService.getTigPubsubServiceJidsById(tigPubsubServiceJids.getServiceId());
            model.addAttribute("tigPubsubServiceJids", tigPubsubServiceJidsResult);
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubServiceJids
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubServiceJids tigPubsubServiceJids) {
        try {
            tigPubsubServiceJids.setUpdateUser(getLoginUserCnName());
            if (tigPubsubServiceJidsService.update(tigPubsubServiceJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubServiceJids
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubServiceJids tigPubsubServiceJids) {
        try {
            tigPubsubServiceJids.setUpdateUser(getLoginUserCnName());
            if (tigPubsubServiceJidsService.delete(tigPubsubServiceJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids delete has error.", e);
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
    public Wrapper<?> query(TigPubsubServiceJidsQuery query) {
        try {
            List<TigPubsubServiceJids> list = tigPubsubServiceJidsService.queryTigPubsubServiceJidsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubServiceJids query has error.", e);
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
    public Wrapper<?> detail(TigPubsubServiceJidsQuery query) {
        if (null == query || null == query.getServiceId()) {
            return illegalArgument();
        }

        try {
            TigPubsubServiceJids tigPubsubServiceJids = tigPubsubServiceJidsService.getTigPubsubServiceJidsById(query.getServiceId());
            if (tigPubsubServiceJids != null) {
                return new Wrapper<TigPubsubServiceJids>().result(tigPubsubServiceJids);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubServiceJids has error.", e);
            return error();
        }
    }
}
