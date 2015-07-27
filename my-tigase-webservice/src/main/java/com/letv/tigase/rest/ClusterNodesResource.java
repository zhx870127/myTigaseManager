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
import com.letv.tigase.domain.ClusterNodes;
import com.letv.tigase.sdk.api.request.ClusterNodesRequest;
import com.letv.tigase.sdk.api.response.ClusterNodesResponse;
import com.letv.tigase.service.ClusterNodesService;

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
public class ClusterNodesResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ClusterNodesService clusterNodesService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/clusterNodes/getClusterNodes")
    public Wrapper<?> getClusterNodes(ClusterNodesRequest request) {
        if (null == request || null == request.getHostname()) {
            this.logger.error("getClusterNodes 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ClusterNodes clusterNodes = clusterNodesService.getClusterNodesById(request.getHostname());
            ClusterNodesResponse response = convert(clusterNodes);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ClusterNodesResponse convert(ClusterNodes clusterNodes) {
        if (null == clusterNodes) {
            return null;
        }

        ClusterNodesResponse clusterNodesResponse = new ClusterNodesResponse();
        BeanUtils.copyProperties(clusterNodes, clusterNodesResponse);
        return clusterNodesResponse;
    }

    // 数据转换
    private List<ClusterNodesResponse> convertList(List<ClusterNodes> clusterNodess) {
        if (CollectionUtils.isEmpty(clusterNodess)) {
            return null;
        }

        List<ClusterNodesResponse> list = new ArrayList<ClusterNodesResponse>(clusterNodess.size());
        for (ClusterNodes clusterNodes : clusterNodess) {
            list.add(convert(clusterNodes));
        }
        return list;
    } 

}
