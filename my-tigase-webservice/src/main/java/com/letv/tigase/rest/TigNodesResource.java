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
import com.letv.tigase.domain.TigNodes;
import com.letv.tigase.sdk.api.request.TigNodesRequest;
import com.letv.tigase.sdk.api.response.TigNodesResponse;
import com.letv.tigase.service.TigNodesService;

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
public class TigNodesResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigNodesService tigNodesService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigNodes/getTigNodes")
    public Wrapper<?> getTigNodes(TigNodesRequest request) {
        if (null == request || null == request.getNid()) {
            this.logger.error("getTigNodes 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigNodes tigNodes = tigNodesService.getTigNodesById(request.getNid());
            TigNodesResponse response = convert(tigNodes);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigNodesResponse convert(TigNodes tigNodes) {
        if (null == tigNodes) {
            return null;
        }

        TigNodesResponse tigNodesResponse = new TigNodesResponse();
        BeanUtils.copyProperties(tigNodes, tigNodesResponse);
        return tigNodesResponse;
    }

    // 数据转换
    private List<TigNodesResponse> convertList(List<TigNodes> tigNodess) {
        if (CollectionUtils.isEmpty(tigNodess)) {
            return null;
        }

        List<TigNodesResponse> list = new ArrayList<TigNodesResponse>(tigNodess.size());
        for (TigNodes tigNodes : tigNodess) {
            list.add(convert(tigNodes));
        }
        return list;
    } 

}
