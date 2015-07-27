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
import com.letv.tigase.domain.TigPubsubAffiliations;
import com.letv.tigase.sdk.api.request.TigPubsubAffiliationsRequest;
import com.letv.tigase.sdk.api.response.TigPubsubAffiliationsResponse;
import com.letv.tigase.service.TigPubsubAffiliationsService;

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
public class TigPubsubAffiliationsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubAffiliationsService tigPubsubAffiliationsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubAffiliations/getTigPubsubAffiliations")
    public Wrapper<?> getTigPubsubAffiliations(TigPubsubAffiliationsRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getTigPubsubAffiliations 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubAffiliations tigPubsubAffiliations = tigPubsubAffiliationsService.getTigPubsubAffiliationsById(request.getJidId());
            TigPubsubAffiliationsResponse response = convert(tigPubsubAffiliations);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubAffiliationsResponse convert(TigPubsubAffiliations tigPubsubAffiliations) {
        if (null == tigPubsubAffiliations) {
            return null;
        }

        TigPubsubAffiliationsResponse tigPubsubAffiliationsResponse = new TigPubsubAffiliationsResponse();
        BeanUtils.copyProperties(tigPubsubAffiliations, tigPubsubAffiliationsResponse);
        return tigPubsubAffiliationsResponse;
    }

    // 数据转换
    private List<TigPubsubAffiliationsResponse> convertList(List<TigPubsubAffiliations> tigPubsubAffiliationss) {
        if (CollectionUtils.isEmpty(tigPubsubAffiliationss)) {
            return null;
        }

        List<TigPubsubAffiliationsResponse> list = new ArrayList<TigPubsubAffiliationsResponse>(tigPubsubAffiliationss.size());
        for (TigPubsubAffiliations tigPubsubAffiliations : tigPubsubAffiliationss) {
            list.add(convert(tigPubsubAffiliations));
        }
        return list;
    } 

}
