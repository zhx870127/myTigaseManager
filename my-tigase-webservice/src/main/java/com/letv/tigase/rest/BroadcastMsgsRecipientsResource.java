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
import com.letv.tigase.domain.BroadcastMsgsRecipients;
import com.letv.tigase.sdk.api.request.BroadcastMsgsRecipientsRequest;
import com.letv.tigase.sdk.api.response.BroadcastMsgsRecipientsResponse;
import com.letv.tigase.service.BroadcastMsgsRecipientsService;

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
public class BroadcastMsgsRecipientsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private BroadcastMsgsRecipientsService broadcastMsgsRecipientsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/broadcastMsgsRecipients/getBroadcastMsgsRecipients")
    public Wrapper<?> getBroadcastMsgsRecipients(BroadcastMsgsRecipientsRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getBroadcastMsgsRecipients 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            BroadcastMsgsRecipients broadcastMsgsRecipients = broadcastMsgsRecipientsService.getBroadcastMsgsRecipientsById(request.getJidId());
            BroadcastMsgsRecipientsResponse response = convert(broadcastMsgsRecipients);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private BroadcastMsgsRecipientsResponse convert(BroadcastMsgsRecipients broadcastMsgsRecipients) {
        if (null == broadcastMsgsRecipients) {
            return null;
        }

        BroadcastMsgsRecipientsResponse broadcastMsgsRecipientsResponse = new BroadcastMsgsRecipientsResponse();
        BeanUtils.copyProperties(broadcastMsgsRecipients, broadcastMsgsRecipientsResponse);
        return broadcastMsgsRecipientsResponse;
    }

    // 数据转换
    private List<BroadcastMsgsRecipientsResponse> convertList(List<BroadcastMsgsRecipients> broadcastMsgsRecipientss) {
        if (CollectionUtils.isEmpty(broadcastMsgsRecipientss)) {
            return null;
        }

        List<BroadcastMsgsRecipientsResponse> list = new ArrayList<BroadcastMsgsRecipientsResponse>(broadcastMsgsRecipientss.size());
        for (BroadcastMsgsRecipients broadcastMsgsRecipients : broadcastMsgsRecipientss) {
            list.add(convert(broadcastMsgsRecipients));
        }
        return list;
    } 

}
