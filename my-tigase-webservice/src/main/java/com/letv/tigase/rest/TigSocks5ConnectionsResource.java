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
import com.letv.tigase.domain.TigSocks5Connections;
import com.letv.tigase.sdk.api.request.TigSocks5ConnectionsRequest;
import com.letv.tigase.sdk.api.response.TigSocks5ConnectionsResponse;
import com.letv.tigase.service.TigSocks5ConnectionsService;

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
public class TigSocks5ConnectionsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigSocks5ConnectionsService tigSocks5ConnectionsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigSocks5Connections/getTigSocks5Connections")
    public Wrapper<?> getTigSocks5Connections(TigSocks5ConnectionsRequest request) {
        if (null == request || null == request.getConnId()) {
            this.logger.error("getTigSocks5Connections 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigSocks5Connections tigSocks5Connections = tigSocks5ConnectionsService.getTigSocks5ConnectionsById(request.getConnId());
            TigSocks5ConnectionsResponse response = convert(tigSocks5Connections);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigSocks5ConnectionsResponse convert(TigSocks5Connections tigSocks5Connections) {
        if (null == tigSocks5Connections) {
            return null;
        }

        TigSocks5ConnectionsResponse tigSocks5ConnectionsResponse = new TigSocks5ConnectionsResponse();
        BeanUtils.copyProperties(tigSocks5Connections, tigSocks5ConnectionsResponse);
        return tigSocks5ConnectionsResponse;
    }

    // 数据转换
    private List<TigSocks5ConnectionsResponse> convertList(List<TigSocks5Connections> tigSocks5Connectionss) {
        if (CollectionUtils.isEmpty(tigSocks5Connectionss)) {
            return null;
        }

        List<TigSocks5ConnectionsResponse> list = new ArrayList<TigSocks5ConnectionsResponse>(tigSocks5Connectionss.size());
        for (TigSocks5Connections tigSocks5Connections : tigSocks5Connectionss) {
            list.add(convert(tigSocks5Connections));
        }
        return list;
    } 

}
