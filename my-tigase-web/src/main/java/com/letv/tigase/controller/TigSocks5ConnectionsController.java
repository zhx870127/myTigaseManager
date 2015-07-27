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
import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.domain.query.TigSocks5ConnectionsQuery;
import com.letv.tigase.service.TigSocks5ConnectionsService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigSocks5ConnectionsController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigSocks5Connections")
public class TigSocks5ConnectionsController extends BaseController {

    @Autowired
    private TigSocks5ConnectionsService tigSocks5ConnectionsService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigSocks5Connections";
    
    private static final Log LOG = LogFactory.getLog(TigSocks5ConnectionsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigSocks5ConnectionsQuery query) {
        try {
            List<TigSocks5Connections> dataList = tigSocks5ConnectionsService.queryTigSocks5ConnectionsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigSocks5Connections index has error.", e);
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
     * @param tigSocks5Connections
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigSocks5Connections tigSocks5Connections) {
        try {
            tigSocks5Connections.setCreateUser(getLoginUserCnName());
            if (tigSocks5ConnectionsService.insert(tigSocks5Connections)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigSocks5Connections add fail, exist tigSocks5Connections.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigSocks5Connections add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigSocks5Connections
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigSocks5Connections tigSocks5Connections) {
        try {
            TigSocks5Connections tigSocks5ConnectionsResult = tigSocks5ConnectionsService.getTigSocks5ConnectionsById(tigSocks5Connections.getConnId());
            model.addAttribute("tigSocks5Connections", tigSocks5ConnectionsResult);
        } catch (Exception e) {
            LOG.error("tigSocks5Connections updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigSocks5Connections
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigSocks5Connections tigSocks5Connections) {
        try {
            tigSocks5Connections.setUpdateUser(getLoginUserCnName());
            if (tigSocks5ConnectionsService.update(tigSocks5Connections)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Connections update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigSocks5Connections
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigSocks5Connections tigSocks5Connections) {
        try {
            tigSocks5Connections.setUpdateUser(getLoginUserCnName());
            if (tigSocks5ConnectionsService.delete(tigSocks5Connections)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Connections delete has error.", e);
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
    public Wrapper<?> query(TigSocks5ConnectionsQuery query) {
        try {
            List<TigSocks5Connections> list = tigSocks5ConnectionsService.queryTigSocks5ConnectionsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Connections query has error.", e);
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
    public Wrapper<?> detail(TigSocks5ConnectionsQuery query) {
        if (null == query || null == query.getConnId()) {
            return illegalArgument();
        }

        try {
            TigSocks5Connections tigSocks5Connections = tigSocks5ConnectionsService.getTigSocks5ConnectionsById(query.getConnId());
            if (tigSocks5Connections != null) {
                return new Wrapper<TigSocks5Connections>().result(tigSocks5Connections);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigSocks5Connections has error.", e);
            return error();
        }
    }
}
