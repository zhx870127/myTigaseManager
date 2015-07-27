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
import com.letv.tigase.domain.TigPubsubSubscriptions;
import com.letv.tigase.sdk.api.request.TigPubsubSubscriptionsRequest;
import com.letv.tigase.sdk.api.response.TigPubsubSubscriptionsResponse;
import com.letv.tigase.service.TigPubsubSubscriptionsService;

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
public class TigPubsubSubscriptionsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubSubscriptionsService tigPubsubSubscriptionsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubSubscriptions/getTigPubsubSubscriptions")
    public Wrapper<?> getTigPubsubSubscriptions(TigPubsubSubscriptionsRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getTigPubsubSubscriptions 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubSubscriptions tigPubsubSubscriptions = tigPubsubSubscriptionsService.getTigPubsubSubscriptionsById(request.getJidId());
            TigPubsubSubscriptionsResponse response = convert(tigPubsubSubscriptions);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubSubscriptionsResponse convert(TigPubsubSubscriptions tigPubsubSubscriptions) {
        if (null == tigPubsubSubscriptions) {
            return null;
        }

        TigPubsubSubscriptionsResponse tigPubsubSubscriptionsResponse = new TigPubsubSubscriptionsResponse();
        BeanUtils.copyProperties(tigPubsubSubscriptions, tigPubsubSubscriptionsResponse);
        return tigPubsubSubscriptionsResponse;
    }

    // 数据转换
    private List<TigPubsubSubscriptionsResponse> convertList(List<TigPubsubSubscriptions> tigPubsubSubscriptionss) {
        if (CollectionUtils.isEmpty(tigPubsubSubscriptionss)) {
            return null;
        }

        List<TigPubsubSubscriptionsResponse> list = new ArrayList<TigPubsubSubscriptionsResponse>(tigPubsubSubscriptionss.size());
        for (TigPubsubSubscriptions tigPubsubSubscriptions : tigPubsubSubscriptionss) {
            list.add(convert(tigPubsubSubscriptions));
        }
        return list;
    } 

}
