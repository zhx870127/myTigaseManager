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
import com.letv.tigase.domain.TigUsers;
import com.letv.tigase.sdk.api.request.TigUsersRequest;
import com.letv.tigase.sdk.api.response.TigUsersResponse;
import com.letv.tigase.service.TigUsersService;

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
public class TigUsersResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigUsersService tigUsersService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigUsers/getTigUsers")
    public Wrapper<?> getTigUsers(TigUsersRequest request) {
        if (null == request || null == request.getUid()) {
            this.logger.error("getTigUsers 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigUsers tigUsers = tigUsersService.getTigUsersById(request.getUid());
            TigUsersResponse response = convert(tigUsers);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigUsersResponse convert(TigUsers tigUsers) {
        if (null == tigUsers) {
            return null;
        }

        TigUsersResponse tigUsersResponse = new TigUsersResponse();
        BeanUtils.copyProperties(tigUsers, tigUsersResponse);
        return tigUsersResponse;
    }

    // 数据转换
    private List<TigUsersResponse> convertList(List<TigUsers> tigUserss) {
        if (CollectionUtils.isEmpty(tigUserss)) {
            return null;
        }

        List<TigUsersResponse> list = new ArrayList<TigUsersResponse>(tigUserss.size());
        for (TigUsers tigUsers : tigUserss) {
            list.add(convert(tigUsers));
        }
        return list;
    } 

}
