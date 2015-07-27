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
import com.letv.tigase.domain.MsgHistory;
import com.letv.tigase.sdk.api.request.MsgHistoryRequest;
import com.letv.tigase.sdk.api.response.MsgHistoryResponse;
import com.letv.tigase.service.MsgHistoryService;

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
public class MsgHistoryResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private MsgHistoryService msgHistoryService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/msgHistory/getMsgHistory")
    public Wrapper<?> getMsgHistory(MsgHistoryRequest request) {
        if (null == request || null == request.getMsgId()) {
            this.logger.error("getMsgHistory 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            MsgHistory msgHistory = msgHistoryService.getMsgHistoryById(request.getMsgId());
            MsgHistoryResponse response = convert(msgHistory);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private MsgHistoryResponse convert(MsgHistory msgHistory) {
        if (null == msgHistory) {
            return null;
        }

        MsgHistoryResponse msgHistoryResponse = new MsgHistoryResponse();
        BeanUtils.copyProperties(msgHistory, msgHistoryResponse);
        return msgHistoryResponse;
    }

    // 数据转换
    private List<MsgHistoryResponse> convertList(List<MsgHistory> msgHistorys) {
        if (CollectionUtils.isEmpty(msgHistorys)) {
            return null;
        }

        List<MsgHistoryResponse> list = new ArrayList<MsgHistoryResponse>(msgHistorys.size());
        for (MsgHistory msgHistory : msgHistorys) {
            list.add(convert(msgHistory));
        }
        return list;
    } 

}
