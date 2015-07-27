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
import com.letv.tigase.domain.TigSocks5Users;
import com.letv.tigase.sdk.api.request.TigSocks5UsersRequest;
import com.letv.tigase.sdk.api.response.TigSocks5UsersResponse;
import com.letv.tigase.service.TigSocks5UsersService;

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
public class TigSocks5UsersResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigSocks5UsersService tigSocks5UsersService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigSocks5Users/getTigSocks5Users")
    public Wrapper<?> getTigSocks5Users(TigSocks5UsersRequest request) {
        if (null == request || null == request.getUid()) {
            this.logger.error("getTigSocks5Users 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigSocks5Users tigSocks5Users = tigSocks5UsersService.getTigSocks5UsersById(request.getUid());
            TigSocks5UsersResponse response = convert(tigSocks5Users);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigSocks5UsersResponse convert(TigSocks5Users tigSocks5Users) {
        if (null == tigSocks5Users) {
            return null;
        }

        TigSocks5UsersResponse tigSocks5UsersResponse = new TigSocks5UsersResponse();
        BeanUtils.copyProperties(tigSocks5Users, tigSocks5UsersResponse);
        return tigSocks5UsersResponse;
    }

    // 数据转换
    private List<TigSocks5UsersResponse> convertList(List<TigSocks5Users> tigSocks5Userss) {
        if (CollectionUtils.isEmpty(tigSocks5Userss)) {
            return null;
        }

        List<TigSocks5UsersResponse> list = new ArrayList<TigSocks5UsersResponse>(tigSocks5Userss.size());
        for (TigSocks5Users tigSocks5Users : tigSocks5Userss) {
            list.add(convert(tigSocks5Users));
        }
        return list;
    } 

}
