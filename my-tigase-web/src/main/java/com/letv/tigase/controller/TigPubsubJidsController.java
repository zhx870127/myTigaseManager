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
import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.domain.query.TigPubsubJidsQuery;
import com.letv.tigase.service.TigPubsubJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubJidsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubJids")
public class TigPubsubJidsController extends BaseController {

    @Autowired
    private TigPubsubJidsService tigPubsubJidsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubJids";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubJidsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubJidsQuery query) {
        try {
            List<TigPubsubJids> dataList = tigPubsubJidsService.queryTigPubsubJidsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubJids index has error.", e);
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
     * @param tigPubsubJids
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubJids tigPubsubJids) {
        try {
            tigPubsubJids.setCreateUser(getLoginUserCnName());
            if (tigPubsubJidsService.insert(tigPubsubJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubJids add fail, exist tigPubsubJids.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubJids add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubJids
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubJids tigPubsubJids) {
        try {
            TigPubsubJids tigPubsubJidsResult = tigPubsubJidsService.getTigPubsubJidsById(tigPubsubJids.getJidId());
            model.addAttribute("tigPubsubJids", tigPubsubJidsResult);
        } catch (Exception e) {
            LOG.error("tigPubsubJids updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubJids
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubJids tigPubsubJids) {
        try {
            tigPubsubJids.setUpdateUser(getLoginUserCnName());
            if (tigPubsubJidsService.update(tigPubsubJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubJids update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubJids
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubJids tigPubsubJids) {
        try {
            tigPubsubJids.setUpdateUser(getLoginUserCnName());
            if (tigPubsubJidsService.delete(tigPubsubJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubJids delete has error.", e);
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
    public Wrapper<?> query(TigPubsubJidsQuery query) {
        try {
            List<TigPubsubJids> list = tigPubsubJidsService.queryTigPubsubJidsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubJids query has error.", e);
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
    public Wrapper<?> detail(TigPubsubJidsQuery query) {
        if (null == query || null == query.getJidId()) {
            return illegalArgument();
        }

        try {
            TigPubsubJids tigPubsubJids = tigPubsubJidsService.getTigPubsubJidsById(query.getJidId());
            if (tigPubsubJids != null) {
                return new Wrapper<TigPubsubJids>().result(tigPubsubJids);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubJids has error.", e);
            return error();
        }
    }
}
