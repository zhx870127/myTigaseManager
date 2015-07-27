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
import com.letv.tigase.domain.BroadcastMsgs;
import com.letv.tigase.sdk.api.request.BroadcastMsgsRequest;
import com.letv.tigase.sdk.api.response.BroadcastMsgsResponse;
import com.letv.tigase.service.BroadcastMsgsService;

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
public class BroadcastMsgsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private BroadcastMsgsService broadcastMsgsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/broadcastMsgs/getBroadcastMsgs")
    public Wrapper<?> getBroadcastMsgs(BroadcastMsgsRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getBroadcastMsgs 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            BroadcastMsgs broadcastMsgs = broadcastMsgsService.getBroadcastMsgsById(request.getId());
            BroadcastMsgsResponse response = convert(broadcastMsgs);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private BroadcastMsgsResponse convert(BroadcastMsgs broadcastMsgs) {
        if (null == broadcastMsgs) {
            return null;
        }

        BroadcastMsgsResponse broadcastMsgsResponse = new BroadcastMsgsResponse();
        BeanUtils.copyProperties(broadcastMsgs, broadcastMsgsResponse);
        return broadcastMsgsResponse;
    }

    // 数据转换
    private List<BroadcastMsgsResponse> convertList(List<BroadcastMsgs> broadcastMsgss) {
        if (CollectionUtils.isEmpty(broadcastMsgss)) {
            return null;
        }

        List<BroadcastMsgsResponse> list = new ArrayList<BroadcastMsgsResponse>(broadcastMsgss.size());
        for (BroadcastMsgs broadcastMsgs : broadcastMsgss) {
            list.add(convert(broadcastMsgs));
        }
        return list;
    } 

}
