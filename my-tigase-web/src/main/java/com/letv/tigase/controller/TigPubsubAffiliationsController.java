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
import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.domain.query.TigPubsubAffiliationsQuery;
import com.letv.tigase.service.TigPubsubAffiliationsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubAffiliationsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubAffiliations")
public class TigPubsubAffiliationsController extends BaseController {

    @Autowired
    private TigPubsubAffiliationsService tigPubsubAffiliationsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubAffiliations";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubAffiliationsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubAffiliationsQuery query) {
        try {
            List<TigPubsubAffiliations> dataList = tigPubsubAffiliationsService.queryTigPubsubAffiliationsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations index has error.", e);
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
     * @param tigPubsubAffiliations
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubAffiliations tigPubsubAffiliations) {
        try {
            tigPubsubAffiliations.setCreateUser(getLoginUserCnName());
            if (tigPubsubAffiliationsService.insert(tigPubsubAffiliations)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubAffiliations add fail, exist tigPubsubAffiliations.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubAffiliations
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubAffiliations tigPubsubAffiliations) {
        try {
            TigPubsubAffiliations tigPubsubAffiliationsResult = tigPubsubAffiliationsService.getTigPubsubAffiliationsById(tigPubsubAffiliations.getJidId());
            model.addAttribute("tigPubsubAffiliations", tigPubsubAffiliationsResult);
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubAffiliations
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubAffiliations tigPubsubAffiliations) {
        try {
            tigPubsubAffiliations.setUpdateUser(getLoginUserCnName());
            if (tigPubsubAffiliationsService.update(tigPubsubAffiliations)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubAffiliations
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubAffiliations tigPubsubAffiliations) {
        try {
            tigPubsubAffiliations.setUpdateUser(getLoginUserCnName());
            if (tigPubsubAffiliationsService.delete(tigPubsubAffiliations)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations delete has error.", e);
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
    public Wrapper<?> query(TigPubsubAffiliationsQuery query) {
        try {
            List<TigPubsubAffiliations> list = tigPubsubAffiliationsService.queryTigPubsubAffiliationsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubAffiliations query has error.", e);
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
    public Wrapper<?> detail(TigPubsubAffiliationsQuery query) {
        if (null == query || null == query.getJidId()) {
            return illegalArgument();
        }

        try {
            TigPubsubAffiliations tigPubsubAffiliations = tigPubsubAffiliationsService.getTigPubsubAffiliationsById(query.getJidId());
            if (tigPubsubAffiliations != null) {
                return new Wrapper<TigPubsubAffiliations>().result(tigPubsubAffiliations);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubAffiliations has error.", e);
            return error();
        }
    }
}
