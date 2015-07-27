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
import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.domain.query.TigPubsubNodesQuery;
import com.letv.tigase.service.TigPubsubNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigPubsubNodesController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigPubsubNodes")
public class TigPubsubNodesController extends BaseController {

    @Autowired
    private TigPubsubNodesService tigPubsubNodesService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigPubsubNodes";
    
    private static final Log LOG = LogFactory.getLog(TigPubsubNodesController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigPubsubNodesQuery query) {
        try {
            List<TigPubsubNodes> dataList = tigPubsubNodesService.queryTigPubsubNodesListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigPubsubNodes index has error.", e);
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
     * @param tigPubsubNodes
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigPubsubNodes tigPubsubNodes) {
        try {
            tigPubsubNodes.setCreateUser(getLoginUserCnName());
            if (tigPubsubNodesService.insert(tigPubsubNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigPubsubNodes add fail, exist tigPubsubNodes.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigPubsubNodes add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigPubsubNodes
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigPubsubNodes tigPubsubNodes) {
        try {
            TigPubsubNodes tigPubsubNodesResult = tigPubsubNodesService.getTigPubsubNodesById(tigPubsubNodes.getNodeId());
            model.addAttribute("tigPubsubNodes", tigPubsubNodesResult);
        } catch (Exception e) {
            LOG.error("tigPubsubNodes updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigPubsubNodes
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigPubsubNodes tigPubsubNodes) {
        try {
            tigPubsubNodes.setUpdateUser(getLoginUserCnName());
            if (tigPubsubNodesService.update(tigPubsubNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubNodes update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigPubsubNodes
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigPubsubNodes tigPubsubNodes) {
        try {
            tigPubsubNodes.setUpdateUser(getLoginUserCnName());
            if (tigPubsubNodesService.delete(tigPubsubNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubNodes delete has error.", e);
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
    public Wrapper<?> query(TigPubsubNodesQuery query) {
        try {
            List<TigPubsubNodes> list = tigPubsubNodesService.queryTigPubsubNodesList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigPubsubNodes query has error.", e);
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
    public Wrapper<?> detail(TigPubsubNodesQuery query) {
        if (null == query || null == query.getNodeId()) {
            return illegalArgument();
        }

        try {
            TigPubsubNodes tigPubsubNodes = tigPubsubNodesService.getTigPubsubNodesById(query.getNodeId());
            if (tigPubsubNodes != null) {
                return new Wrapper<TigPubsubNodes>().result(tigPubsubNodes);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigPubsubNodes has error.", e);
            return error();
        }
    }
}
