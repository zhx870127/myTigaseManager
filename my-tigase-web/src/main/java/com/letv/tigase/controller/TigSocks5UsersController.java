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
import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.domain.query.TigSocks5UsersQuery;
import com.letv.tigase.service.TigSocks5UsersService;
import com.letv.tigase.utils.exceptions.ExistedException;
import com.letv.common.utils.page.PageUtil;
import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * TigSocks5UsersController ：控制器
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
*/
@Controller
@RequestMapping("tigSocks5Users")
public class TigSocks5UsersController extends BaseController {

    @Autowired
    private TigSocks5UsersService tigSocks5UsersService;

    /** 视图前缀 */
    private static final String viewPrefix ="tigSocks5Users";
    
    private static final Log LOG = LogFactory.getLog(TigSocks5UsersController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TigSocks5UsersQuery query) {
        try {
            List<TigSocks5Users> dataList = tigSocks5UsersService.queryTigSocks5UsersListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tigSocks5Users index has error.", e);
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
     * @param tigSocks5Users
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TigSocks5Users tigSocks5Users) {
        try {
            tigSocks5Users.setCreateUser(getLoginUserCnName());
            if (tigSocks5UsersService.insert(tigSocks5Users)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tigSocks5Users add fail, exist tigSocks5Users.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tigSocks5Users add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * ----更新跳转
     * 
     * @param model
     * @param tigSocks5Users
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TigSocks5Users tigSocks5Users) {
        try {
            TigSocks5Users tigSocks5UsersResult = tigSocks5UsersService.getTigSocks5UsersById(tigSocks5Users.getUid());
            model.addAttribute("tigSocks5Users", tigSocks5UsersResult);
        } catch (Exception e) {
            LOG.error("tigSocks5Users updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * ----更新
     * 
     * @param model
     * @param tigSocks5Users
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TigSocks5Users tigSocks5Users) {
        try {
            tigSocks5Users.setUpdateUser(getLoginUserCnName());
            if (tigSocks5UsersService.update(tigSocks5Users)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Users update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * ----删除
     * 
     * @param tigSocks5Users
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TigSocks5Users tigSocks5Users) {
        try {
            tigSocks5Users.setUpdateUser(getLoginUserCnName());
            if (tigSocks5UsersService.delete(tigSocks5Users)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Users delete has error.", e);
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
    public Wrapper<?> query(TigSocks5UsersQuery query) {
        try {
            List<TigSocks5Users> list = tigSocks5UsersService.queryTigSocks5UsersList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tigSocks5Users query has error.", e);
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
    public Wrapper<?> detail(TigSocks5UsersQuery query) {
        if (null == query || null == query.getUid()) {
            return illegalArgument();
        }

        try {
            TigSocks5Users tigSocks5Users = tigSocks5UsersService.getTigSocks5UsersById(query.getUid());
            if (tigSocks5Users != null) {
                return new Wrapper<TigSocks5Users>().result(tigSocks5Users);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tigSocks5Users has error.", e);
            return error();
        }
    }
}
