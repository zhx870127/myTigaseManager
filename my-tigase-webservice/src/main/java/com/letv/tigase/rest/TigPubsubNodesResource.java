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
import com.letv.tigase.domain.TigPubsubNodes;
import com.letv.tigase.sdk.api.request.TigPubsubNodesRequest;
import com.letv.tigase.sdk.api.response.TigPubsubNodesResponse;
import com.letv.tigase.service.TigPubsubNodesService;

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
public class TigPubsubNodesResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubNodesService tigPubsubNodesService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubNodes/getTigPubsubNodes")
    public Wrapper<?> getTigPubsubNodes(TigPubsubNodesRequest request) {
        if (null == request || null == request.getNodeId()) {
            this.logger.error("getTigPubsubNodes 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubNodes tigPubsubNodes = tigPubsubNodesService.getTigPubsubNodesById(request.getNodeId());
            TigPubsubNodesResponse response = convert(tigPubsubNodes);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubNodesResponse convert(TigPubsubNodes tigPubsubNodes) {
        if (null == tigPubsubNodes) {
            return null;
        }

        TigPubsubNodesResponse tigPubsubNodesResponse = new TigPubsubNodesResponse();
        BeanUtils.copyProperties(tigPubsubNodes, tigPubsubNodesResponse);
        return tigPubsubNodesResponse;
    }

    // 数据转换
    private List<TigPubsubNodesResponse> convertList(List<TigPubsubNodes> tigPubsubNodess) {
        if (CollectionUtils.isEmpty(tigPubsubNodess)) {
            return null;
        }

        List<TigPubsubNodesResponse> list = new ArrayList<TigPubsubNodesResponse>(tigPubsubNodess.size());
        for (TigPubsubNodes tigPubsubNodes : tigPubsubNodess) {
            list.add(convert(tigPubsubNodes));
        }
        return list;
    } 

}
