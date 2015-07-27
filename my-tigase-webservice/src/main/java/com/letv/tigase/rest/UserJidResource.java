package com.letv.tigase.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;
import com.letv.tigase.domain.UserJid;
import com.letv.tigase.sdk.api.request.UserJidRequest;
import com.letv.tigase.sdk.api.response.UserJidResponse;
import com.letv.tigase.service.UserJidService;

/**
 * REST服务：提供有关的接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserJidResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserJidService userJidService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/userJid/getUserJid")
    public Wrapper<?> getUserJid(UserJidRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getUserJid 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserJid userJid = userJidService.getUserJidById(request.getJidId());
            UserJidResponse response = convert(userJid);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserJidResponse convert(UserJid userJid) {
        if (null == userJid) {
            return null;
        }

        UserJidResponse userJidResponse = new UserJidResponse();
        BeanUtils.copyProperties(userJid, userJidResponse);
        return userJidResponse;
    }

    // 数据转换
    private List<UserJidResponse> convertList(List<UserJid> userJids) {
        if (CollectionUtils.isEmpty(userJids)) {
            return null;
        }

        List<UserJidResponse> list = new ArrayList<UserJidResponse>(userJids.size());
        for (UserJid userJid : userJids) {
            list.add(convert(userJid));
        }
        return list;
    } 

}
