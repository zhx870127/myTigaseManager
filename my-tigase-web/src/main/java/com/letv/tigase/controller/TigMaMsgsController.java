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
import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.domain.query.TigMaMsgsQuery;
import com.letv.tigase.service.TigMaMsgsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigMaMsgsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigMaMsgs")
public class TigMaMsgsController extends BaseController {

    @Autowired
    private TigMaMsgsService tigMaMsgsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigMaMsgs";
    
    private static final Log LOG = LogFactory.getLog(TigMaMsgsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigMaMsgsQuery query) {
        try {
            List<TigMaMsgs> dataList = tigMaMsgsService.queryTigMaMsgsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigMaMsgs index has error.", e);
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
     * @param tigMaMsgs
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigMaMsgs tigMaMsgs) {
        try {
            tigMaMsgs.setCreateUser(getLoginUserCnName());
            if (tigMaMsgsService.insert(tigMaMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigMaMsgs add fail, exist tigMaMsgs.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigMaMsgs add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigMaMsgs
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigMaMsgs tigMaMsgs) {
        try {
            TigMaMsgs tigMaMsgsResult = tigMaMsgsService.getTigMaMsgsById(tigMaMsgs.getMsgId());
            model.addAttribute("tigMaMsgs", tigMaMsgsResult);
        } catch (Exception e) {
            LOG.error("tigMaMsgs updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigMaMsgs
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigMaMsgs tigMaMsgs) {
        try {
            tigMaMsgs.setUpdateUser(getLoginUserCnName());
            if (tigMaMsgsService.update(tigMaMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaMsgs update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigMaMsgs
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigMaMsgs tigMaMsgs) {
        try {
            tigMaMsgs.setUpdateUser(getLoginUserCnName());
            if (tigMaMsgsService.delete(tigMaMsgs)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaMsgs delete has error.", e);
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
    public Wrapper<?> query(TigMaMsgsQuery query) {
        try {
            List<TigMaMsgs> list = tigMaMsgsService.queryTigMaMsgsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigMaMsgs query has error.", e);
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
    public Wrapper<?> detail(TigMaMsgsQuery query) {
        if (null == query || null == query.getMsgId()) {
            return illegalArgument();
        }

        try {
            TigMaMsgs tigMaMsgs = tigMaMsgsService.getTigMaMsgsById(query.getMsgId());
            if (tigMaMsgs != null) {
                return new Wrapper<TigMaMsgs>().result(tigMaMsgs);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigMaMsgs has error.", e);
            return error();
        }
    }
}
