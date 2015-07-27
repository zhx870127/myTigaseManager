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
import com.letv.tigase.domain.TigPubsubItems;
import com.letv.tigase.sdk.api.request.TigPubsubItemsRequest;
import com.letv.tigase.sdk.api.response.TigPubsubItemsResponse;
import com.letv.tigase.service.TigPubsubItemsService;

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
public class TigPubsubItemsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigPubsubItemsService tigPubsubItemsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigPubsubItems/getTigPubsubItems")
    public Wrapper<?> getTigPubsubItems(TigPubsubItemsRequest request) {
        if (null == request || null == request.getIdSha1()) {
            this.logger.error("getTigPubsubItems 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigPubsubItems tigPubsubItems = tigPubsubItemsService.getTigPubsubItemsById(request.getIdSha1());
            TigPubsubItemsResponse response = convert(tigPubsubItems);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigPubsubItemsResponse convert(TigPubsubItems tigPubsubItems) {
        if (null == tigPubsubItems) {
            return null;
        }

        TigPubsubItemsResponse tigPubsubItemsResponse = new TigPubsubItemsResponse();
        BeanUtils.copyProperties(tigPubsubItems, tigPubsubItemsResponse);
        return tigPubsubItemsResponse;
    }

    // 数据转换
    private List<TigPubsubItemsResponse> convertList(List<TigPubsubItems> tigPubsubItemss) {
        if (CollectionUtils.isEmpty(tigPubsubItemss)) {
            return null;
        }

        List<TigPubsubItemsResponse> list = new ArrayList<TigPubsubItemsResponse>(tigPubsubItemss.size());
        for (TigPubsubItems tigPubsubItems : tigPubsubItemss) {
            list.add(convert(tigPubsubItems));
        }
        return list;
    } 

}
