package com.letv.tigase.controller.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.letv.common.utils.DateHelper;

/**
 * 基本控制器：提供通用的方法
 * 
 * @author lijianzhong
 */
public abstract class BaseController extends WrapController {

    protected final Log logger = LogFactory.getLog(this.getClass());

    /**
     * init binder, set datetime format
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat(DateHelper.DATE_TIME_FORMAT);
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    /**
     * 获取登录用户名
     * 
     * @return
     */
    public String getLoginUserName() {
        return "acb";

    } 

    /**
     * 获取登录用户编号
     * 
     * @return
     */
    public String getLoginUserNo() {
        return "123";
    }
}
