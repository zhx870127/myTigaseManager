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
import com.letv.tigase.domain.TigPubsubServiceJids;
import com.letv.tigase.sdk.api.request.TigPubsubServiceJidsRequest;
import com.letv.tigase.sdk.api.response.TigPubsubServiceJidsResponse;
import com.letv.tigase.service.TigPubsubServiceJidsService;

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
public class TigPubsubServiceJidsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubServiceJidsService tigPubsubServiceJidsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubServiceJids/getTigPubsubServiceJids")
    public Wrapper<?> getTigPubsubServiceJids(TigPubsubServiceJidsRequest request) {
        if (null == request || null == request.getServiceId()) {
            this.logger.error("getTigPubsubServiceJids 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubServiceJids tigPubsubServiceJids = tigPubsubServiceJidsService.getTigPubsubServiceJidsById(request.getServiceId());
            TigPubsubServiceJidsResponse response = convert(tigPubsubServiceJids);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubServiceJidsResponse convert(TigPubsubServiceJids tigPubsubServiceJids) {
        if (null == tigPubsubServiceJids) {
            return null;
        }

        TigPubsubServiceJidsResponse tigPubsubServiceJidsResponse = new TigPubsubServiceJidsResponse();
        BeanUtils.copyProperties(tigPubsubServiceJids, tigPubsubServiceJidsResponse);
        return tigPubsubServiceJidsResponse;
    }

    // 数据转换
    private List<TigPubsubServiceJidsResponse> convertList(List<TigPubsubServiceJids> tigPubsubServiceJidss) {
        if (CollectionUtils.isEmpty(tigPubsubServiceJidss)) {
            return null;
        }

        List<TigPubsubServiceJidsResponse> list = new ArrayList<TigPubsubServiceJidsResponse>(tigPubsubServiceJidss.size());
        for (TigPubsubServiceJids tigPubsubServiceJids : tigPubsubServiceJidss) {
            list.add(convert(tigPubsubServiceJids));
        }
        return list;
    } 

}
