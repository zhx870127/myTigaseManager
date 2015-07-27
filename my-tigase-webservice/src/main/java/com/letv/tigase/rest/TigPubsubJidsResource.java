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
import com.letv.tigase.domain.TigPubsubJids;
import com.letv.tigase.sdk.api.request.TigPubsubJidsRequest;
import com.letv.tigase.sdk.api.response.TigPubsubJidsResponse;
import com.letv.tigase.service.TigPubsubJidsService;

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
public class TigPubsubJidsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubJidsService tigPubsubJidsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubJids/getTigPubsubJids")
    public Wrapper<?> getTigPubsubJids(TigPubsubJidsRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getTigPubsubJids 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubJids tigPubsubJids = tigPubsubJidsService.getTigPubsubJidsById(request.getJidId());
            TigPubsubJidsResponse response = convert(tigPubsubJids);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubJidsResponse convert(TigPubsubJids tigPubsubJids) {
        if (null == tigPubsubJids) {
            return null;
        }

        TigPubsubJidsResponse tigPubsubJidsResponse = new TigPubsubJidsResponse();
        BeanUtils.copyProperties(tigPubsubJids, tigPubsubJidsResponse);
        return tigPubsubJidsResponse;
    }

    // 数据转换
    private List<TigPubsubJidsResponse> convertList(List<TigPubsubJids> tigPubsubJidss) {
        if (CollectionUtils.isEmpty(tigPubsubJidss)) {
            return null;
        }

        List<TigPubsubJidsResponse> list = new ArrayList<TigPubsubJidsResponse>(tigPubsubJidss.size());
        for (TigPubsubJids tigPubsubJids : tigPubsubJidss) {
            list.add(convert(tigPubsubJids));
        }
        return list;
    } 

}
