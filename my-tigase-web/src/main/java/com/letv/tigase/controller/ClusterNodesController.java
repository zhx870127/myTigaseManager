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
import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.domain.query.ClusterNodesQuery;
import com.letv.tigase.service.ClusterNodesService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * ClusterNodesController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("clusterNodes")
public class ClusterNodesController extends BaseController {

    @Autowired
    private ClusterNodesService clusterNodesService;

    /** 视图前缀 */
    private static final String viewPrefix ="clusterNodes";
    
    private static final Log LOG = LogFactory.getLog(ClusterNodesController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ClusterNodesQuery query) {
        try {
            List<ClusterNodes> dataList = clusterNodesService.queryClusterNodesListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("clusterNodes index has error.", e);
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
     * @param clusterNodes
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ClusterNodes clusterNodes) {
        try {
            clusterNodes.setCreateUser(getLoginUserCnName());
            if (clusterNodesService.insert(clusterNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("clusterNodes add fail, exist clusterNodes.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("clusterNodes add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param clusterNodes
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ClusterNodes clusterNodes) {
        try {
            ClusterNodes clusterNodesResult = clusterNodesService.getClusterNodesById(clusterNodes.getHostname());
            model.addAttribute("clusterNodes", clusterNodesResult);
        } catch (Exception e) {
            LOG.error("clusterNodes updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param clusterNodes
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ClusterNodes clusterNodes) {
        try {
            clusterNodes.setUpdateUser(getLoginUserCnName());
            if (clusterNodesService.update(clusterNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("clusterNodes update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param clusterNodes
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ClusterNodes clusterNodes) {
        try {
            clusterNodes.setUpdateUser(getLoginUserCnName());
            if (clusterNodesService.delete(clusterNodes)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("clusterNodes delete has error.", e);
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
    public Wrapper<?> query(ClusterNodesQuery query) {
        try {
            List<ClusterNodes> list = clusterNodesService.queryClusterNodesList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("clusterNodes query has error.", e);
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
    public Wrapper<?> detail(ClusterNodesQuery query) {
        if (null == query || null == query.getHostname()) {
            return illegalArgument();
        }

        try {
            ClusterNodes clusterNodes = clusterNodesService.getClusterNodesById(query.getHostname());
            if (clusterNodes != null) {
                return new Wrapper<ClusterNodes>().result(clusterNodes);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail clusterNodes has error.", e);
            return error();
        }
    }
}
