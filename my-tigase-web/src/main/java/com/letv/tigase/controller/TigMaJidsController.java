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
import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.domain.query.TigMaJidsQuery;
import com.letv.tigase.service.TigMaJidsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigMaJidsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigMaJids")
public class TigMaJidsController extends BaseController {

    @Autowired
    private TigMaJidsService tigMaJidsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigMaJids";
    
    private static final Log LOG = LogFactory.getLog(TigMaJidsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigMaJidsQuery query) {
        try {
            List<TigMaJids> dataList = tigMaJidsService.queryTigMaJidsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigMaJids index has error.", e);
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
     * @param tigMaJids
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigMaJids tigMaJids) {
        try {
            tigMaJids.setCreateUser(getLoginUserCnName());
            if (tigMaJidsService.insert(tigMaJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigMaJids add fail, exist tigMaJids.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigMaJids add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigMaJids
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigMaJids tigMaJids) {
        try {
            TigMaJids tigMaJidsResult = tigMaJidsService.getTigMaJidsById(tigMaJids.getJidId());
            model.addAttribute("tigMaJids", tigMaJidsResult);
        } catch (Exception e) {
            LOG.error("tigMaJids updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigMaJids
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigMaJids tigMaJids) {
        try {
            tigMaJids.setUpdateUser(getLoginUserCnName());
            if (tigMaJidsService.update(tigMaJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaJids update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigMaJids
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigMaJids tigMaJids) {
        try {
            tigMaJids.setUpdateUser(getLoginUserCnName());
            if (tigMaJidsService.delete(tigMaJids)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaJids delete has error.", e);
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
    public Wrapper<?> query(TigMaJidsQuery query) {
        try {
            List<TigMaJids> list = tigMaJidsService.queryTigMaJidsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaJids query has error.", e);
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
    public Wrapper<?> detail(TigMaJidsQuery query) {
        if (null == query || null == query.getJidId()) {
            return illegalArgument();
        }

        try {
            TigMaJids tigMaJids = tigMaJidsService.getTigMaJidsById(query.getJidId());
            if (tigMaJids != null) {
                return new Wrapper<TigMaJids>().result(tigMaJids);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigMaJids has error.", e);
            return error();
        }
    }
}
